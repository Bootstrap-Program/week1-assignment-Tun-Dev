pipeline {
  agent { label 'linux' }
    stages {
      stage('initial') {
        steps {
          checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
                    userRemoteConfigs: 
                    [[credentialsId: 'gitHubCreds', url: 'https://github.com/gideonaina/wordCount.git']]])
        }
      }
      stage('Creds') {
        steps {
          
          withCredentials([usernamePassword(credentialsId: 'restEndpoint', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh returnStdout: true, script: '''
        curl -X -v POST https://restful-booker.herokuapp.com/auth -H "Content-Type: application/json" -d "{ "username" : $USERNAME, "password" : $PASSWORD}"
        '''
      }
    }
}

      stage('Test') {
        steps {

          sh 'echo "***************CREDS*****************"'
          withCredentials([usernamePassword(credentialsId: 'restEndpoint', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            sh returnStdout: true, script: '''
            cd wordCount && ls -la && chmod +x gradlew && ./gradlew --refresh-dependencies &&  ./gradlew test -Puname=$USERNAME -Dpass=$PASSWORD
            '''
          }
        }
     }
  }
}
