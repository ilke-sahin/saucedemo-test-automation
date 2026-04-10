pipeline {
    agent any


    triggers {
        cron('H 2 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {

                bat 'mvn clean test'
            }
        }
    }

    post {
        always {

            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
    }
}