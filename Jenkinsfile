def gv
def projectPath = "./project"
def repName = "192.168.88.14:8083"
def imgName= "java-maven-app"

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
                    gv.getSrc("${projectPath}")
                }
            }
        }
        stage("increment ver") {
            steps{
                script {
                    gv.incrementVer("${projectPath}")
                }
            }
        }
        stage("build jar") {
            steps{
                script {
                    gv.buildJar("${projectPath}")
                }
            }
        }
        stage("build image") {
            steps{
                script {
                    gv.buildImage("${repName}", "${imgName}", "${projectPath}")
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
