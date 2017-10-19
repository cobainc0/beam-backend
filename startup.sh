#!/usr/bin/env bash
<<<<<<< HEAD
./kill-service.sh &&
echo "...Killing any running service and launching Beam on port http://localhost:53000/api :)" &&
echo "try ..." &&
echo "http://localhost:53000/api/jsonResponse" &&
echo "http://localhost:53000/api/stringResponse" &&
./gradlew run

=======

./gradlew run && echo 'Beam starting on port 53000 :)'
>>>>>>> 82d44f46f0f2233ea8cd30badb0e039a5d0cab35
