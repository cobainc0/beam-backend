#!/usr/bin/env bash

BID=`ps -ef | grep $JAVA_HOME/bin/java | grep "BeamApplication"  | grep -v grep | awk '{ print $2 }'`
GID=`ps -ef | grep $JAVA_HOME/bin/java | grep "GradleWrapperMain"  | grep -v grep | awk '{ print $2 }'`

if [[ ! -z "$BID" ]] && [[ ! -z "$GID" ]]
then 
<<<<<<< HEAD
	kill -9 $GID &&
	echo "Killing Gradle Application" &&
	kill -9 $BID &&
	echo "Killing Beam Application" &&
	kill -9 $BID
=======
	kill -9 $BID &&
	kill -9 $GID &&
	echo "Killing Beam & Gradle Application"
>>>>>>> 82d44f46f0f2233ea8cd30badb0e039a5d0cab35
fi

