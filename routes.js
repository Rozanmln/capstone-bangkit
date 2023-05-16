const express = require('express')
const router = express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')

router.get("/", (req, res) => {
    console.log("Response Success")
    res.send("Response Success!")
})

const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'here',
});

db.connect((err) => {
    if (err) {
        throw err;
    }
    console.log('Connected to MySQL database');
});

router.post('/register', (req, res) => {
    const { username, email, password, role } = req.body;
    const user = { username, email, password, role };

    db.query('INSERT INTO users SET ?', user, (err, result) => {
        if (err) {
            res.status(500).json({ error: err.message });
        } else {
            res.status(200).json({ message: 'User registered successfully' });
        }
    });
});

module.exports = router