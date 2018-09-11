#!/bin/bash
##command-jenkins- BUILD_ID=dontKillMe /data/jenkins-scripts/test-script.sh 9000 DEV

# COMMAND LINE VARIABLES
# deploy port SECOND ARGUMENT
# Ex: 8090 | 8091 | 8092
echo start

serverPort=$1
echo $1

environment=$2
sudo su

#####
##### DONT CHANGE HERE ##############
#jar file
# $WORKSPACE is a jenkins var
echo $WORKSPACE
sourFile=$WORKSPACE/Test-Spring-Boot/target/com.mitrai.testspring.jar
echo $sourFile
destFile=/data/$environment/test-spring/com.mitrai.testspring.jar
echo $destFile
### FUNCTIONS
##############

function stopServer(){
echo insideStop
echo ” “
echo “Stoping process on port: $serverPort”
fuser -k $severport/tcp > redirection &
echo ” “
}

function deleteFiles(){
echo “Deleting $destFile”
rm -rf $destFile

echo ” “
}

function copyFiles(){
echo “Copying files from $sourFile”
cp $sourFile $destFile

echo ” “
}

function run(){

#echo “java -jar $destFile –server.port=$serverPort $properties” | at now + 1 minutes

nohup nice java -jar $destFile –server.port=$serverPort &

echo “COMMAND: nohup nice java -jar $destFile “

echo ” “
}

### FUNCTIONS CALLS
#####################

# 1 – stop server on port …
stopServer

# 2 – delete destinations folder content
deleteFiles

# 3 – copy files to deploy dir
copyFiles

changeFilePermission
# 4 – start server
run
