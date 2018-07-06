'use strict';
const teamRepository = require('../repositories/team-repository');
const Team = require('./Team');
var teams = [];


exports.create = async function (name) {
  const createTeam = await teamRepository.create({name: name});
};

// exports.update = async function (id, name, members) {
//   const update = await teamRepository.update({name: name})
// };


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

exports.idlist = function () {
  return new Promise((resolve, reject) => {
    resolve(Object.ids(teams));
  });
};

exports.count = function () {
  return new Promise((resolve, reject) => {
    resolve(teams.length);
  })
}