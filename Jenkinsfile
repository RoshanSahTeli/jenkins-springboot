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
        }
        
    }
}