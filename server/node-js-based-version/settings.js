const mongoPrefix = 'mongodb://';
const user = 'admin';
const password = 'admin';
const host = 'localhost';
const port = 27017;
const dbName = 'scout';
const dbURL = 'mongodb://admin:admin@localhost:27017/scout'

exports.dbUrl = function () {
  return mongoPrefix + user + ':' + password + '@' + host + ':' + port + '/' + dbName;
}
