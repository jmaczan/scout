#!/bin/bash
# $1 is absolute path to data on host
docker run -d -p 27017:27017 -v /home/jmaczan/development/scout/server/node-js-based-version/data:/data scout-mongodb
