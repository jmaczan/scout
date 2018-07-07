var express = require('express');
const teamService = require('../services/team-service');
var teamsApp = express();

teamsApp.get('/', function(req, res, next) {
  teamService.readAll().then(response => {
    res.send(response);
  }).catch(err => {
    console.log('all error', err)
    next(err);
  })
});

teamsApp.get('/:name', function(req, res, next) {
  teamService.readByName(req.params.name).then(response => {
    res.send(response);
  }).catch(err => {
    console.log('name error', err)
    next(err);
  })
});

teamsApp.post('/create', function(req, res, next) {
  teamService.create(req.body.name).then(response => {
    return response.json();
  }).then(response => {
    res.send(response);
  }).catch(err => {
    next(err);
  })
});

module.exports = teamsApp;
