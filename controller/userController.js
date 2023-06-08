const mysql = require('mysql')
const jwt = require('jsonwebtoken')
const bcrypt = require('bcrypt')

require('dotenv').config()
const secretKey = process.env.SECRET_KEY


const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'here',
})

db.connect((err) => {
    if (err) {
        throw err;
    }
    console.log('Connected to MySQL database')
})

const register = (req, res) => {
    const { username, email, password, role } = req.body

    const query = 'SELECT * FROM users WHERE username = ?'

    db.query(query, [username], (err, results) => {
        if (err) {
            console.error('Error executing the query: ', err)
            return res.status(500).json({ message: 'Internal server error' })
        }
        if (results.length > 0) {
            return res.status(409).json({ message: 'User already exists' })
        }

        const hashedPassword = bcrypt.hashSync(password, 10)
        const user = { username, email, hashedPassword, role }

        db.query('INSERT INTO users SET ?', user, (err, result) => {
            if (err) {
                res.status(500).json({ error: err.message })
            } else {
                res.status(200).json({ message: 'User registered successfully' })
            }
        })
    })
}

const login = (req, res) => {
    const { username, password } = req.body;

    db.query('SELECT * FROM users WHERE username = ?', username, (err, results) => {
        if (err) {
            res.status(500).json({ error: err.message })
        } else if (results.length === 0) {
            res.status(401).json({ message: 'Invalid username or password' })
        } else {
            const user = results[0];
            if (!bcrypt.compareSync(password, user.hashedPassword)) {
                res.status(401).json({ message: 'Invalid username or password' })

            } else {
                const token = jwt.sign({ username, role: user.role }, secretKey)
                res.status(200).json({ message: 'Login successful', token })
            }
        }
    })
}

module.exports = {
    register,
    login
}