#!/usr/bin/env bash

set -e
cat src/main/resources/banner.txt &&
echo "launch MySQL..." &&
sudo /usr/local/mysql/support-files/mysql.server stop &&
sudo /usr/local/mysql/support-files/mysql.server start &&
echo "launching local DB - MySQL.." &&
#sudo mysql -u root -p &&
./kill-service.sh &&
echo "...Killing any running service and launching Beam locally @ http://localhost:53000/api :)" &&
echo "try ..." &&
echo "http://localhost:53000/api/jsonResponse" &&
echo "http://localhost:53000/api/stringResponse" &&
echo 'Beam starting on port 53000 :)' &&
./gradlew run
