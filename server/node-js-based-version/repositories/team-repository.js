'use strict';
const { MongoClient } = require('mongodb');
const { dbUrl } = require('../settings');

let client;

async function getConnection() {
  if (!client) {
    let mongoClient = await MongoClient.connect(dbUrl());
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
    .insertOne({name: name})
  return result;
}

exports.readAll = async function readAll() {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .find({})
    .toArray();
  return result;
} 

exports.readByName = async function read(name) {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .find({name: name})
    .toArray();
  return result;
} 

exports.read = async function read(id) {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .find({id: id});
  return result;
} 

exports.destroy = async function destroy(id) {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .destroy({id: id});
  return result;
} 

exports.destroyByName = async function destroyByName(name) {
  const client = await getConnection();
  const result = await client
    .db('scout')
    .collection('teams')
    .destroy({name: name})
    .toArray();
  return result;
} 
