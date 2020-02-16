#!/bin/bash

# Note : run script as root
# A script that loads the test database
# More information under link: https://dev.mysql.com/doc/sakila/en/sakila-installation.html
# If your root user in db has other name run script with your root db name as argument


pathToSqlScript=`realpath .`;
yourRootInDb=root
host=127.0.0.1

if [ $# -lt 1 ]; then
     echo -e "\e[34mMissing password argument\e[39m";
     echo    "example: ./load_sakila_data.sh yourRootDbPassword";
     echo    "example: ./load_sakila_data.sh yourRootDbPassword yourRootName";
     exit 1;
fi

if [ $# -eq 2 ]; then
     yourRootInDb=$2;
fi

echo -e "\e[34mStart inport data\e[39m";

if ! /usr/bin/mysql --database=sakila --user=$yourRootInDb --password=$2 --host=$host --port=3306 < $pathToSqlScript"/sakila-data.sql"; then exit 1; fi
if ! /usr/bin/mysql --database=sakila --user=$yourRootInDb --password=$2  --host=$host --port=3306 < $pathToSqlScript"/sakila-schema.sql"  ; then exit 1; fi

echo -e "\e[34mDone\e[39m"