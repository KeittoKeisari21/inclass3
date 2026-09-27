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
                jacoco(path:'target/site/jacoco/jacoco.xml')
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

        stage('Docker Hub Login') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'docker_hub',
                        usernameVariable: 'DOCKER_USERNAME',
                        passwordVariable: 'DOCKER_PASSWORD'
                    )
                ]) {
                    bat '''
                        echo %DOCKER_PASSWORD% | docker login --username %DOCKER_USERNAME% --password-stdin
                    '''
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                bat 'docker push %DOCKER_IMAGE%:latest'
            }
        }
    }
}
