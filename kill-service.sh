#!/usr/bin/env bash

BID=`ps -ef | grep $JAVA_HOME/bin/java | grep "BeamApplication"  | grep -v grep | awk '{ print $2 }'`
GID=`ps -ef | grep $JAVA_HOME/bin/java | grep "GradleWrapperMain"  | grep -v grep | awk '{ print $2 }'`

if [[ ! -z "$BID" ]] && [[ ! -z "$GID" ]]
then 
	kill -9 $BID &&
	kill -9 $GID &&
	echo "Killing Beam & Gradle Application"
fi

