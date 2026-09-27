pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'keittokeisari21/tempconverter_filipv'
    }

    stages {

        stage('check') {
            steps {
                git branch: 'main', url: 'https://github.com/KeittoKeisari21/inclass3'
            }
        }

        stage('build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('JaCoCo') {
            steps {
                jacoco(path: 'target/site/jacoco/jacoco.xml')
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE%:latest .'
            }
        }

        stage('Run Docker Image') {
            steps {
                bat 'docker run --rm %DOCKER_IMAGE%:latest'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withDockerRegistry(credentialsId: '9d809128-a80e-4661-a6d0-de88e394dfa7', url: 'https://index.docker.io/v1/') {
                    bat 'docker push %DOCKER_IMAGE%:latest'
                }
            }
        }
    }
}