node {

    stage('pull sources') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CheckoutOption', timeout: 30]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'stockgit', url: 'https://github.com/hyhGitOk/stock-backend.git']]])
    }


    stage('build eureka server') {
        agent { //使用docker做agent，指定了镜像和文件映射
            docker {
                image 'maven:3-alpine'  //这个镜像没有的话会自动获取
                args '-v /root/.m2:/root/.m2'
            }
        }
        steps {
            sh "mvn -f eureka-server clean install -Dmaven.test.skip=true"
        }
    }
}