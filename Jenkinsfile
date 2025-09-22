pipeline {
    agent{
    label "pipeline"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Ahmodiyy/calculator.git', branch: 'main'
            }
        }
        stage('Linux permission') {
            steps {
            bat "docker version"
//                 sh "chmod +x gradlew"
//                 sh "docker version"
            }
        }
        stage('gradle build') {
                     steps {
                         bat "./gradlew clean"
                         bat "./gradlew build"

                     }
                }
        stage("Code Coverage") {
              steps {
                  bat "./gradlew jacocoTestReport"
//                   publishHTML(target: [
//                                       allowMissing: false,
//                                       alwaysLinkToLastBuild: false,
//                                       keepAll: true,
//                                       reportDir: 'build/reports/jacoco/test/html',
//                                       reportFiles: 'index.html',
//                                       reportName: 'JaCoCo Report'
//                                   ])
                  bat "./gradlew jacocoTestCoverageVerification"
              }
        }
//         stage("Static code analysis") {
//                steps {
//                    bat "./gradlew checkstyleMain"
//                    publishHTML(target: [
//                                       allowMissing: false,
//                                       alwaysLinkToLastBuild: false,
//                                       keepAll: true,
//                                       reportDir: 'build/reports/checkstyle',
//                                       reportFiles: 'main.html',
//                                       reportName: 'Checkstyle Report'
//                                   ])
//                }
//         }
        stage('docker build') {
                 steps {
                     bat "docker build -t chtwirls/calculator ."
                 }
        }
//         stage("Docker login") {
//
//           steps {
//             withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'dockerhub',
//                               usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
//               bat "docker login --username $USERNAME --password $PASSWORD"
//             }
//           }
//         }

        stage('docker push') {
                 steps {
                     bat "docker push chtwirls/calculator"
                 }
        }


    }
//     post {
//             always {
//                 mail to: 'ezeikechristopher@gmail.com',
//                     subject: "Completed Pipeline for: ${currentBuild.fullDisplayName}",
//                     body: "Your build completed, please check: ${env.BUILD_URL}"
//                 slackSend channel: '#test', color: 'green', message: "The pipeline ${currentBuild.fullDisplayName} result."
//             }
//         }
}
