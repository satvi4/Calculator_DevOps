pipeline {
    environment{
        dockerimg = ''
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }
    agent any

    stages {
        stage('Git pull') {
            steps {
                git 'https://github.com/satvi4/Calculator_DevOps'
            }
        }
        stage('Maven Build'){
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker image build'){
            steps {
                script{
                    dockerimg = docker.build("satvi4/calculator:${BUILD_NUMBER}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    docker.withRegistry('','dockerhub'){
                    dockerimg.push()
                    }
                }
            }
        }
        stage('Removing Docker Image from Local') {
            steps {
                sh "docker rmi satvi4/calculator:${BUILD_NUMBER}"
                sh "docker stop sci_calc"
                sh "docker rm sci_calc"
            }
        }
        stage('Ansible Deploy'){
            steps{
                sh 'export LANG=en_US.UTF-8'
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'playbook.yml', sudoUser: null
            }
        }
    }
}
