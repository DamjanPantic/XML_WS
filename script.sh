#!/bin/bash

TOKEN=4e07408562bedb8b60ce05c1decfe3ad16b72230967de01f640b7e4729b49fce



while [ : ]
do

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
	"lat": "12321332419230",
	"lng": "11111111111111",
	"carId": "1"
}' \
  http://localhost:8080/location/entries/4e07408562bedb8b60ce05c1decfe3ad16b72230967de01f640b7e4729b49fce

sleep 10
done
