'use strict';

var teams = [];
const Team = require('./Team');

exports.update = exports.create = function(id, name, members) {
  return new Promise((resolve, reject) => {
    // mongo db request
    teams[id] = new Team(id, name, members);
    resolve(teams[id]);
  });
};

exports.read = function (id) {
  return new Promise((resolve, reject) => {
    if (teams[id]) { 
      resolve(teams[id]);
    } else {
      reject(`Team ${id} doesn't exist`);
    }
  });
};

exports.destroy = function (id) {
  return new Promise((resolve, reject) => {
    if (teams[id]) {
      delete teams[id];
      resolve();
    } else {
      reject(`Team ${id} doesn't exist`);
    }
  });
};

exports.idlist = function() {
  return new Promise((resolve, reject) => {
    resolve(Object.ids(teams));
  });
};

exports.count = function () {
  return new Promise((resolve, reject) => {
    resolve(teams.length);
  })
}