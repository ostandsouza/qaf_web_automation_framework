@Library('cmn-jenkins-modules-jenkins-infra@master') _
def branch_name   = "${BRANCH_NAME}"
def dev_regex     = /development/
def stage_regex   = /master/
def prod_regex    = /^v[0-9]+\.[0-9]+\.[0-9]+/
def dev_account   = "${CTP_DEV_AWS_ACCOUNT_NUMBER}"
def stage_account = "${CTP_STAGE_AWS_ACCOUNT_NUMBER}"
def prod_account  = "${CTP_PROD_AWS_ACCOUNT_NUMBER}"

pipeline {
    agent { label "IBDGenericAgent" }
    tools {
        maven 'maven3.8.6'
        jdk 'jdk1.8'
    }
    environment {
        CREDS = credentials('CTP_DEV_CREDS')
       
        IBD_CLIENT_GITHUB_TOKEN = credentials('IBD_CLIENT_GITHUB_TOKEN')
        IBD_CLIENT_GITHUB_API = "https://github.geo.conti.de"
        IBD_CLIENT_GITHUB_KEY_TITLE = "IBD CLI Jenkins SSH Manager"
    }

    stages {
          stage('Setup') {
              steps {
                  script {
                    sshManager this
                  }
              }
        }
        stage('Test') {
            steps {
                script {
                    sh( script: 'uname -a')
                    sh( script: 'printenv')
                    sh( script: 'mvn -v')
                    sh( script: 'java -version')
                    sh ( script: 'mvn -gs ${WORKSPACE}/settings.xml clean test')
                }
            }
        }
//         stage('Report') {
//             steps {
//                 script {
//                     env.FAILURE_STAGE = 'reports'
//                     allure([
//                             includeProperties: false,
//                             jdk: '',
//                             properties: [],
//                             reportBuildPolicy: 'ALWAYS',
//                             results: [[path: 'target/allure-results']]
//                     ])
//                 }
//             }
//         }
        stage ('publish_HTML') {
            when {
                expression {
                    return currentBuild.result == 'FAILURE'||currentBuild.result == 'SUCCESS'||currentBuild.result == 'UNSTABLE';
                }
            }
          steps {
               script{
                    env.FAILURE_STAGE = 'publish_HTML'

                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, includes: '**/customized-emailable-report.html', keepAll: true, reportDir: 'target/surefire-reports', reportFiles: 'customized-emailable-report.html', reportName: 'htmlReport', reportTitles: 'htmlReport'])

                }
            }
        }
    }
    post {
        always {
            script {
               def summary = junit testResults: 'target/surefire-reports/TEST-*.xml'

               env.mailRecipients = 'ostan@codecraft.co.in, oston.prithesh.dsouza-EXT@continental.com'
            }
        }
         success{
            echo "Success Pipeline: ${currentBuild.fullDisplayName}"
            script {
                    def now = new Date().format("yyyy/MM/dd HH:mm", TimeZone.getTimeZone('IST'))
                    def jobName = currentBuild.fullDisplayName
                    emailext body: '''${FILE,path="target/surefire-reports/customized-emailable-report.html"}''',
                    mimeType: 'text/html',
                    subject: "[Jenkins] Conti+ Test Automation Report on ${now}",
                    to: "${env.mailRecipients}",
                    replyTo: "${env.mailRecipients}",
                    recipientProviders: [[$class: 'CulpritsRecipientProvider']]
                }
        }
        failure {
            echo "Failure Pipeline: ${currentBuild.result}"
            echo "Attention @here ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed."
            script {
                    def now = new Date().format("yyyy/MM/dd HH:mm", TimeZone.getTimeZone('IST'))
                    def jobName = currentBuild.fullDisplayName
                    emailext body: '''${FILE,path="target/surefire-reports/customized-emailable-report.html"}''',
                    mimeType: 'text/html',
                    subject: "[Jenkins] Conti+ Test Automation Report on ${now}",
                    to: "${env.mailRecipients}",
                    replyTo: "${env.mailRecipients}",
                    recipientProviders: [[$class: 'CulpritsRecipientProvider']]
            }
        }
        unstable{
            echo "Unstable Pipeline: ${currentBuild.result}"
            script {
                    def now = new Date().format("yyyy/MM/dd HH:mm", TimeZone.getTimeZone('IST'))
                    def jobName = currentBuild.fullDisplayName
                    emailext body: '''${FILE,path="target/surefire-reports/customized-emailable-report.html"}''',
                    mimeType: 'text/html',
                    subject: "[Jenkins] Conti+ Test Automation Report on ${now}",
                    to: "${env.mailRecipients}",
                    replyTo: "${env.mailRecipients}",
                    recipientProviders: [[$class: 'CulpritsRecipientProvider']]
            }
        }
    }
}