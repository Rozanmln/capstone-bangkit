const { Sequelize } = require('sequelize');

const db = new Sequelize('here2', 'root', 'password', {
  host: '34.101.119.140',
  dialect: 'mysql',
});

module.exports = db;
