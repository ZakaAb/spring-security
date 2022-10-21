#!/bin/bash


curl --location --request POST 'http://localhost:8080/api/auth/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "'$1'",
        "email": "'$1'@elit.dz",
            "password": "'$2'",
                "role": ["'$3'"]
                }'
