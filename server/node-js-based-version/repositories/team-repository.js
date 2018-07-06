'use strict';
const { MongoClient } = require('mongodb');

let client;

async function getConnection() {
  if (!client) {
    let mongoClient = await MongoClient.connect('mongodb://admin:admin@localhost:27017/scout');
    client = mongoClient;
    return await client;
  }
  return client;
}

exports.create = async function create(name) {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .find({})
    .toArray();
  return result;
} 

exports.read = async function read(id) {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .find({id: id})
    .toArray();
  return result;
} 