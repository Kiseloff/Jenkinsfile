def getSrc() {
    echo "getting the sources..."
    sh "rm -rf $PROJECT_PATH"
    sh "git clone -b jenkins-jobs https://gitlab.com/nanuchi/java-maven-app.git $PROJECT_PATH"
}

def buildJar() {
    echo "building the app..."
    sh "mvn package -f $PROJECT_PATH"
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'ls -la'
        sh "docker build -t 192.168.88.14:8083/java-maven-app:4.0 $PROJECT_PATH"
        sh "echo $PASS | docker login -u $USER --password-stdin 192.168.88.14:8083"
        sh 'docker push 192.168.88.14:8083/java-maven-app:4.0'
    }
}

def deployApp() {
    echo "deploying the app..."
}

return this
