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

    environment {
        CREDS = credentials('CTP_DEV_CREDS')
        IBD_CLIENT_GITHUB_TOKEN = credentials('IBD_CLIENT_GITHUB_TOKEN')
        IBD_CLIENT_GITHUB_API = "https://github.geo.conti.de"
        IBD_CLIENT_GITHUB_KEY_TITLE = "IBD CLI Jenkins SSH Manager"
        http_proxy = "http://cias.geoaws.com:8080"
        https_proxy = "http://cias.geoaws.com:8080"
    }

    stages {
        stage('Get Commit Message') {
            steps {
                script {
                    env.GIT_COMMIT_MSG = sh(script: 'git log -1 --pretty=%B ${GIT_COMMIT}', returnStdout: true).trim()
                    echo "GIT Commit message is : ${env.GIT_COMMIT_MSG}"
                }
            }
        }

        stage('Check Substring in Commit Message') {
            steps {
                script {
                    def searchString = 'buildthis'
                    if (env.GIT_COMMIT_MSG.toLowerCase().contains(searchString.toLowerCase())) {
                        echo "Commit message contains the substring: ${searchString} (case-insensitive)"
                        lock(resource: "build-${env.BRANCH_NAME}") {
                            stage('Setup') {
                                steps {
                                    sshManager this
                                }
                            }

                            stage('Test') {
                                steps {
                                    sh 'uname -a'
                                    sh 'printenv'
                                    sh 'mvn -v'
                                    sh 'java -version'
                                    sh 'wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb'
                                    sh 'sudo apt-get install ./google-chrome*.deb'
                                    sh 'mvn -s ${WORKSPACE}/settings.xml clean test "-Dchrome.additional.capabilities={\\"goog:chromeOptions\\":{\\"args\\":[\\"--headless\\",\\"--remote-allow-origins=*\\",\\"--disable-gpu\\",\\"--no-sandbox\\",\\"--disable-extensions\\",\\"--disable-dev-shm-usage\\"],\\"extensions\\":[],\\"prefs\\":{\\"download.default_directory\\":\\"${WORKSPACE}/target/downloads\\"}}}"'
                                }
                            }

                            stage('Publish HTML') {
                                steps {
                                    env.FAILURE_STAGE = 'publish_HTML'
                                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, includes: '**/customized-emailable-report.html', keepAll: true, reportDir: 'test-results', reportFiles: 'customized-emailable-report.html', reportName: 'htmlReport', reportTitles: 'htmlReport'])
                                    println("${currentBuild.result}")
                                }
                            }
                        }
                    } else {
                        error "Ignoring build as commit message doesn't contain the substring: ${searchString}"
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                junit testResults: 'test-results/junitreports/TEST-*.xml'
                env.mailRecipients = 'ostan@codecraft.co.in, oston.prithesh.dsouza-EXT@continental.com, vishmitha.2.g-ext@continental.com, supreetha.g-ext@continental.com, piyush.sharma@continental.com, supreetha.g@codecraft.co.in, vishmitha.g@codecraft.co.in, vivekkumar_si@hcl.com, prathiksha.adappa@continental.com, shashidhar.madhuranath@continental.com, chetak.r.m@contitech.de, sakti.prasad.debnath@ptg.contitech.in'
            }
        }

        success {
            echo "Success Pipeline: ${currentBuild.fullDisplayName}"
            script {
                def now = new Date().format("yyyy/MM/dd HH:mm", TimeZone.getTimeZone('IST'))
                emailext body: '''${FILE,path="test-results/customized-emailable-report.html"}''',
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
                emailext body: '''${FILE,path="test-results/customized-emailable-report.html"}''',
                mimeType: 'text/html',
                subject: "[Jenkins] Conti+ Test Automation Report on ${now}",
                to: "${env.mailRecipients}",
                replyTo: "${env.mailRecipients}",
                recipientProviders: [[$class: 'CulpritsRecipientProvider']]
            }
        }

        unstable {
            echo "Unstable Pipeline: ${currentBuild.result}"
            script {
                def now = new Date().format("yyyy/MM/dd HH:mm", TimeZone.getTimeZone('IST'))
                emailext body: '''${FILE,path="test-results/customized-emailable-report.html"}''',
                mimeType: 'text/html',
                subject: "[Jenkins] Conti+ Test Automation Report on ${now}",
                to: "${env.mailRecipients}",
                replyTo: "${env.mailRecipients}",
                recipientProviders: [[$class: 'CulpritsRecipientProvider']]
            }
        }
    }
}