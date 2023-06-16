const { Sequelize } = require('sequelize');

const db = new Sequelize('here2', 'root', 'capstoneC23', {
  host: '35.193.38.255',
  dialect: 'mysql',
});

module.exports = db;
