#!/usr/bin/env bash

./kill-service.sh &&
echo "...Killing any running service and launching Beam on port http://localhost:53000/api :)" &&
echo "try ..." &&
echo "http://localhost:53000/api/jsonResponse" &&
echo "http://localhost:53000/api/stringResponse" &&
echo 'Beam starting on port 53000 :)' &&
./gradlew run
