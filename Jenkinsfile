pipeline {
    agent any
   
    stages {
        
        stage('Test') {
            steps {
                echo 'Hello World'
            }
        }
        
        stage('Git Checkout') {
            steps {
                echo 'Hello World'
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'c9ef3bfd-530e-43f0-a84f-9983a4fd762c', url: 'https://github.com/sandydevops8/Java_SB_Rest_API_Docker.git']])
            }
        }
        
        stage('Build Project to create Jar'){
            steps{
                sh 'mvn clean install'
            } 
        }
        
        stage(' build an image from jar'){
            steps{
                script{
                    sh 'docker build -t sandydevops8/spring-boot-docker .'
                }
            }
        }
        
        stage(' login to docker hub and push image to doccker hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u sandydevops8 -p ${dockerhubpwd}'
                    sh 'docker push sandydevops8/spring-boot-docker'
                }
                }
            }
        }

        stage(' Deploy Image from DockerHub to Kubernetes Cluster , Here single node Minikube'){
             steps{
                 //kubernetesDeploy(configs: 'deploymentservice.yaml', kubeconfigId: 'kubec_config')  
                 withKubeCredentials(kubectlCredentials: [[caCertificate: '', clusterName: '', contextName: '', credentialsId: 'kube_config', namespace: '', serverUrl: '']]) {
                    sh "kubectl apply -f deploymentservice.yaml"
                    }
             }
        }
        
    }
}
