pipeline {
    agent{
        label 'windows_node'
    }

    stages {
        stage('Git-Checkout') {
            steps {
                echo 'Checking out the code from version control...'
                git 'https://github.com/KoyyaAswini/EMS-backend.git'
            }
        }
      stage('Build') {
    steps {
        echo 'Building the Spring Boot Maven project...'
       dir('C:/Users/ASWINI/Documents/SpringBoot/EMS') {

            bat 'mvn clean package'
        }
    }
}
stage('test and deploy'){
    parallel{
        stage('Test') {
            agent{label "windows_node"}
            steps {
                echo 'Running unit tests...'
                // Add your test step here, e.g., running tests
                // sh 'mvn test'
            }
        }
        stage('Deploy') {
            agent{label "master"}
            steps {
                echo 'Deploying the application...'
                // Add your deploy step here, e.g., copy files to server
                // sh 'scp target/your-app.jar user@server:/path/to/deploy'
            }
        }
    }
}
        
        
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
    }
}
