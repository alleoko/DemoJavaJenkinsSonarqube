pipeline {
    agent any

    environment {
        SONARQUBE_ENV = 'SonarQube'  // Name of SonarQube server configured in Jenkins
        SONAR_AUTH_TOKEN = credentials('sonar-token')  // Jenkins credential ID for SonarQube token
    }

    stages {
        stage('Checkout') {
            steps {
                // Assuming the code is in a Git repo; adjust URL and branch as needed
                git branch: 'main', url: 'https://github.com/your-username/demo_jenkins_sonarqube.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=Demo-Jenkins-Sonarqube \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.login=$SONAR_AUTH_TOKEN
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                // Wait for SonarQube analysis to complete and check quality gate
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            // Clean up or archive artifacts
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}