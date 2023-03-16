pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'build stage'
        bat 'mvn -DskipeTests clean package'
        echo 'la construction termin� '
        archiveArtifacts '**/target/*.jar'
      }
    }

    stage('test') {
      parallel {
        stage('smok') {
          steps {
            echo 'test unitaire'
            bat 'mvn -Dtest="com.example.testingweb.smok.**" test'
            echo 'test unitaire fini'
            junit '**/target/surefire-reports/TEST-*.xml'
          }
        }

        stage('test int�gration') {
          steps {
            echo 'test fonctionnel'
            bat 'mvn -Dtest="com.example.testingweb.integration.**" test'
            echo 'integration termin�'
          }
        }

        stage('fonctionnel') {
          steps {
            echo 'smoke test'
            bat 'mvn -Dtest="com.example.testingweb.functional.**" test'
            echo 'test fonctionnel termin�'
          }
        }

      }
    }

    stage('deploy') {
      steps {
        echo 'deploy'
        input(message: 'Voulais -vous continnuer ', ok: 'alons-y')
        echo 'le deployement va demarrer'
        bat 'mvn -DskipTests install'
        echo 'd�ploiement termin�e'
      }
    }

  }
}