#!/usr/bin/env node
const createError = require('http-errors');
const express = require('express');
const path = require('path');
const logger = require('morgan');
const http = require('http');
const cors = require('cors');
const bodyParser = require('body-parser');

var indexRouter = require('./routes/index');
var teamsRouter = require('./routes/teams');

const app = express();

app.use(express.static(__dirname + '/dist'));
app.disable('etag');
app.use(cors());
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use('/', indexRouter);
app.use('/teams', teamsRouter);

app.use('*', (req, res, next) => {
  res.setHeader('Last-Modified', (new Date()).toUTCString());
  res.sendFile(path.join(__dirname + '/../client/dist/index.html'));
});

app.use(function(req, res, next) {
  next(createError(404));
});

app.use(function(err, req, res, next) {
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  res.status(err.status || 500);
});

function normalizePort(value) {
  const port = parseInt(value, 10);

  if (isNaN(port)) {
    return value;
  }

  if (port >= 0) {
    return port;
  }

  return false;
}

const port = normalizePort(process.argv[2] || '3000');
app.set('port', port);

var server = http.createServer(app);

server.listen(port);
server.on('error', onError);
server.on('listening', onListening);

function onError(error) {
  if (error.syscall !== 'listen') {
    throw error;
  }

  var bind = typeof port === 'string'
    ? 'Pipe ' + port
    : 'Port ' + port;

  switch (error.code) {
    case 'EACCES':
      console.error(bind + ' requires elevated privileges');
      process.exit(1);
      break;
    case 'EADDRINUSE':
      console.error(bind + ' is already in use');
      process.exit(1);
      break;
    default:
      throw error;
  }
}

function onListening() {
  var addr = server.address();
}

module.exports = app;