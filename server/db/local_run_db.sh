#!/bin/bash
# path after -v should be source of data for Mongo
docker run --name scout-mongodb -d -v /home/jmaczan/development/scout/server/db/data/db:/data/db -p 27017:27017 scout-mongodb
