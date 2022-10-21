#!/bin/bash

response=$(curl --location --request POST 'http://localhost:8080/api/auth/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "'$1'",
        "password": "'$2'"
        }')

token=$(echo $response | jq '.token' | sed -e 's/\"//g')

echo $token

#set -x
curl --location --request GET 'http://localhost:8080/api/test/all' \
--header 'Authorization: Bearer '$token''

echo

curl --location --request GET 'http://localhost:8080/api/test/user' \
--header 'Authorization: Bearer '$token''

echo
curl --location --request GET 'http://localhost:8080/api/test/mod' \
--header 'Authorization: Bearer '$token''
echo
curl --location --request GET 'http://localhost:8080/api/test/admin' \
--header 'Authorization: Bearer '$token''
