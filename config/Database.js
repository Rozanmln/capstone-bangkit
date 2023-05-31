const { Sequelize } = require("sequelize")

const db = new Sequelize('here2', 'root', '', {
    host: "localhost",
    dialect: "mysql"
})

module.exports = db