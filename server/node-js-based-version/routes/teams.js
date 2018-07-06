var express = require('express');
const teamService = require('../services/team-service');
var router = express.Router();

/* GET teams listing. */
router.get('/', function(req, res, next) {
  const teams = teamService.read()
  res.send('respond with a resource');
});

module.exports = router;
