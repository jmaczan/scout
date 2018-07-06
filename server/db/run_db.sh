#!/bin/bash
# Invokation parameter $1 should be source of data for Mongo - see local_run_db.sh for an example
docker run --name scout-mongodb -d -v $1:/data/db -p 27017 scout-mongodb
