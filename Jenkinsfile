def gv
def PROJECT_PATH = "./project"

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
                }
            }
        }
        stage("get sources") {
            steps{
                script {
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
