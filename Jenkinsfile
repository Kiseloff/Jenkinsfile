def gv

pipeline{
    agent any
    tools {
        maven 'Maven'
    }
    stages{
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                    sh 'ls -la'
                    echo "========="
                }
            }
        }
        stage("get sources") {
            steps{
                script {
                    sh 'ls -la'
                    gv.getSrc()
                }
            }
        }
        stage("build jar") {
            steps{
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps{
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps{
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
