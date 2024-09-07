pipeline {
    agent any
    tools {
        maven 'maven_3.9.9'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RoshanSahTeli/jenkins-springboot']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t roshanteli/devops-integration .'
                }
            }
        }
        stage('Push Image to Hub') {
            steps {
                script {
                    bat 'docker login -u roshanteli -p Pramilaprem12'
                    bat 'docker push roshanteli/devops-integration:latest'
                }
            }
        }
        stage('Deploy to Docker') {
            steps {
                script {
          			def containerExists = bat(script: 'docker ps -a --filter "name=devops-integration" --format "{{.Names}}"', returnStdout: true).trim()

                    if (containerExists) {
                        bat 'docker stop devops-integration || true'
                        bat 'docker rm devops-integration || true'
                    }
                    bat 'docker run -d --name devops-integration -p 8082:8080 roshanteli/devops-integration:latest'
                }
            }
        }
    }
}
