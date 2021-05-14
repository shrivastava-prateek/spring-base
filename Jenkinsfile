pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            //label 'docker-agent'
            args '-v /mnt/c/Users/prate/.m2:/root/.m2:z -u root'
        }
    }
    stages {
        
        stage('Check') { 
            steps {
                sh 'cd /root/.m2; ls -lrt'
               // sh 'cd /mnt/c/var/jenkins/docker-agent/workspace/local-pipeline-springbase; ls -lrt'
            }
        }
        
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}

//remote root dir in agent: /mnt/c/var/jenkins_home
//label : docker-agent
// java -jar agent.jar -jnlpUrl http://localhost:9090/computer/docker-agent/jenkins-agent.jnlp -secret 8d2e7e34df8be493d32bb193d13574439779b2ab159b454c0d1e4a243a23551c -workDir "/mnt/d/jenkins/docker-agent"