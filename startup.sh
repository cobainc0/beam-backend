#!/usr/bin/env bash

set -e

./kill-service.sh &&
echo "...Killing any running service and launching Beam locally @ http://localhost:53000/api :)" &&
echo "try ..." &&
echo "http://localhost:53000/api/jsonResponse" &&
echo "http://localhost:53000/api/stringResponse" &&
echo 'Beam starting on port 53000 :)' &&
./gradlew run
