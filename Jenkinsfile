node {
    //def mvnHome

    stage('pull sources') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CheckoutOption', timeout: 60]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'pubgit', url: 'https://github.com/hyhGitOk/fullstack.git']]])
    }

}