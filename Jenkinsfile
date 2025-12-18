pipeline {
    agent any

    tools {
        jdk 'Java21'
        maven 'apache-maven-3.9.11'
    }

    stages {
        stage('Build & Test') {
            steps {
               bat 'mvn clean test -PRegression'
            }
        }
    }
}
