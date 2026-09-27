pipeline {
    agent any

        stages {
        stage ('check'){
            steps{
                git ''
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