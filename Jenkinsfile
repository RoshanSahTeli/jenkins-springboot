pipeline{
    agent any
    tools{
        maven 'maven_3.9.9'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RoshanSahTeli/jenkins-springboot']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker image'){
             steps{
                script{
                    bat 'docker build -t roshanteli/devops-integration .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                   // withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    bat 'docker login -u roshanteli -p Pramilaprem12'
                   // }
                    bat 'docker push roshanteli/devops-integration:latest'
                }
            }
            stage('Deploy to docker'){
            	steps{
            		script{
            			bat 'docker pull roshanteli/devops-integration:latest'
            			bat 'docker stop devops-integration||true'
            			bat 'docker rm devops-integration || true'
            			bat 'docker run -d --name devops-integration -p 8082:8080 roshanteli/devops-integrations:latest' 
            		}
            	}
            }
        }
        
    }
}