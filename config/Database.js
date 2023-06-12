const { Sequelize } = require("sequelize")

const db = new Sequelize('here2', 'root', 'password', {
    host: "34.101.228.47",
    dialect: "mysql"
})

module.exports = db