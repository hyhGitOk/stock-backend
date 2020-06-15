node {

    stage('pull sources') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CheckoutOption', timeout: 30]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'stockgit', url: 'https://github.com/hyhGitOk/stock-backend.git']]])
    }


    stage('build eureka server') {
        sh "mvn -f eureka-server clean install"
    }
}