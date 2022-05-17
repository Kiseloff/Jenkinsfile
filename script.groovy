def getSrc(projectPath) {
    echo "getting the sources..."
    sh "rm -rf ${projectPath}"
    sh "git clone -b jenkins-jobs https://gitlab.com/nanuchi/java-maven-app.git ${projectPath}"
}

def buildJar(projectPath) {
    echo "building the app..."
    sh "mvn package -f ${projectPath}"
}

def buildImage(String repName, String imgName, String projectPath) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        //sh "docker build -t 192.168.88.14:8083/java-maven-app:4.0 ${projectPath}"
        //sh "echo $PASS | docker login -u $USER --password-stdin 192.168.88.14:8083"
        //sh 'docker push 192.168.88.14:8083/java-maven-app:4.0'
        sh "docker build -t ${repName}/${imgName} ${projectPath}"
        sh "echo $PASS | docker login -u $USER --password-stdin ${repName}"
        sh "docker push ${repName}/${imgName}"
    }
}

def deployApp() {
    echo "deploying the app..."
}

return this
