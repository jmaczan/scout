#!/bin/bash
# $1 is absolute path to data on host
docker run -d -p 27017:27017 -v $1:/data/db scout-mongodb
