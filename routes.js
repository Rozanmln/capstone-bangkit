const express = require('express')
const router = express.Router()
const mysql = require('mysql')
const jwt = require('jsonwebtoken')

const secretKey = 'secret123';

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
    console.log('Connected to MySQL database')
});

router.post('/register', (req, res) => {
    const { username, email, password, role } = req.body
    const user = { username, email, password, role }

    db.query('INSERT INTO users SET ?', user, (err, result) => {
        if (err) {
            res.status(500).json({ error: err.message })
        } else {
            res.status(200).json({ message: 'User registered successfully' })
        }
    });
});

router.post('/login', (req, res) => {
    const { username, password } = req.body;

    db.query('SELECT * FROM users WHERE username = ?', username, (err, results) => {
        if (err) {
            res.status(500).json({ error: err.message });
        } else if (results.length === 0) {
            res.status(401).json({ message: 'Invalid username or password' })
        } else {
            const user = results[0];
            if (user.password === password) {
                const token = jwt.sign({ username, role: user.role }, secretKey)
                res.status(200).json({ message: 'Login successful', token })
            } else {
                res.status(401).json({ message: 'Invalid username or password' })
            }
        }
    });
});

router.get('/protected', authenticateToken, (req, res) => {
    const { username, role } = req.user
    res.status(200).json({ message: 'Protected endpoint accessed', username, role })
})

function authenticateToken(req, res, next) {
    const authHeader = req.headers['authorization']
    const token = authHeader && authHeader.split(' ')[1]
    if (token == null) {
        return res.sendStatus(401)
    }
    jwt.verify(token, secretKey, (err, user) => {
        if (err) {
            return res.sendStatus(403)
        }
        req.user = user
        next()
    })
}

module.exports = router