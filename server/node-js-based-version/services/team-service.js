'use strict';
const teamRepository = require('../repositories/team-repository');

exports.create = async function (name) {
  const createTeam = await teamRepository.create(name);
  return createTeam;
};

exports.read = async function (id) {
  const getTeam = await teamRepository.read(id);
  return getTeam;
};

exports.readAll = async function () {
  const getAllTeams = await teamRepository.readAll();
  return getAllTeams;
};

exports.readByName = async function (name) {
  const getTeams = await teamRepository.readByName(name);
  return getTeams;
};

exports.destroy = async function (id) {
  const removedTeam = await teamRepository.destroy(name);
  return removedTeam;
};

exports.destroyByName = async function (name) {
  const removedTeam = await teamRepository.destroyByName(name);
  return removedTeam;
};