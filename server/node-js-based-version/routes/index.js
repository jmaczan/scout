var express = require('express');
var router = express.Router();
var teams = require('../services/team-service');

router.get('/', (req, res, next) => {
  // teams.keylist()
  // .then(keylist => {
  //   var keyPromises = [];
  //   for (var key of keylist) {
  //     keyPromises.push(
  //       notes.read(key)
  //       .then(note => {
  //         return { key: note.key, title: note.title }
  //       })
  //     );
  //   }
  //   return Promise.all(keyPromises);
  // })
  // .then(notelist => {
  //   res.render('index', { title: 'Notes', notelist: notelist });
  // })
  // .catch(err => {
  //   next(err);
  // })
});

module.exports = router;
