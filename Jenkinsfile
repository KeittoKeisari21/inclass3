pipeline {
    agent any

        stages {
        stage ('check'){
            steps{
                git 'https://github.com/KeittoKeisari21/inclass3'
            }
        }
        stage ('build'){
            steps{
                bat 'mvn clean install'
            }
        }

        stage('test') {
            steps{
                bat 'mvn test'
            }
        }
        stage('jacoco'){
            steps{
                jacoco(path:'target/site/jacoco/jacoco.xml')
            }
        }

    }
}