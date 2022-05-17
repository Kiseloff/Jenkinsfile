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
                    gv.getSrc("${PROJECT_PATH}")
                }
            }
        }
        stage("build jar") {
            steps{
                script {
                    gv.buildJar("${PROJECT_PATH}")
                }
            }
        }
        stage("build image") {
            steps{
                script {
                    gv.buildImage("${PROJECT_PATH}")
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
