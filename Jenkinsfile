pipeline {
  agent { label 'linux' }
    stages {
      stage('Test') {
        steps {
          ./gradlew test
        }
      }
    }
}
