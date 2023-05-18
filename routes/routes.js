const express = require('express')
const router = express.Router()
const userController = require('../controller/userController')
const dashboardController = require('../controller/dashboardController')
const userAuth = require('../middleware/auth')
// const mysql = require('mysql')
// const jwt = require('jsonwebtoken')
// const bcrypt = require('bcrypt')

// const secretKey = 'secret123'

// const db = mysql.createConnection({
//     host: 'localhost',
//     user: 'root',
//     password: '',
//     database: 'here',
// })

// db.connect((err) => {
//     if (err) {
//         throw err;
//     }
//     console.log('Connected to MySQL database')
// })

//route for user registration
// router.post('/register', (req, res) => {
//     const { username, email, password, role } = req.body

//     const query = 'SELECT * FROM users WHERE username = ?'

//     db.query(query, [username], (err, results) => {
//         if (err) {
//             console.error('Error executing the query: ', err)
//             return res.status(500).json({ message: 'Internal server error' })
//         }
//         if (results.length > 0) {
//             return res.status(409).json({ message: 'User already exists' })
//         }
//     })

//     const hashedPassword = bcrypt.hashSync(password, 10)
//     const user = { username, email, hashedPassword, role }

//     db.query('INSERT INTO users SET ?', user, (err, result) => {
//         if (err) {
//             res.status(500).json({ error: err.message })
//         } else {
//             res.status(200).json({ message: 'User registered successfully' })
//         }
//     })
// })

// //route for user login
// router.post('/login', (req, res) => {
//     const { username, password } = req.body;

//     db.query('SELECT * FROM users WHERE username = ?', username, (err, results) => {
//         if (err) {
//             res.status(500).json({ error: err.message })
//         } else if (results.length === 0) {
//             res.status(401).json({ message: 'Invalid username or password' })
//         } else {
//             const user = results[0];
//             if (!bcrypt.compareSync(password, user.hashedPassword)) {
//                 res.status(401).json({ message: 'Invalid username or password' })

//             } else {
//                 const token = jwt.sign({ username, role: user.role }, secretKey)
//                 res.status(200).json({ message: 'Login successful', token })
//             }
//         }
//     })
// })

// //Protected route accessible only to patients
// router.get('/patient/dashboard', authenticateToken, (req, res) => {
//     // Check the role to ensure only patients can access this route
//     if (req.user.role !== '1') {
//         return res.status(403).json({ message: 'Access denied!' })
//     }

//     res.json({ message: 'Patient Dashboard!' })
// })

// //Protected route accessible only to hospitals
// router.get('/hospital/dashboard', authenticateToken, (req, res) => {
//     // Check the role to ensure only patients can access this route
//     if (req.user.role !== '2') {
//         return res.status(403).json({ message: 'Access denied!' })
//     }

//     res.json({ message: 'Hospital Dashboard!' })
// })

// //Protected route accessible only for auth token
// router.get('/protected', authenticateToken, (req, res) => {
//     const { username, role } = req.user
//     res.status(200).json({ message: 'Protected endpoint accessed', username, role })
// })

// function authenticateToken(req, res, next) {
//     const authHeader = req.headers['authorization']
//     const token = authHeader && authHeader.split(' ')[1]
//     if (token == null) {
//         return res.sendStatus(401)
//     }
//     jwt.verify(token, secretKey, (err, user) => {
//         if (err) {
//             return res.sendStatus(403)
//         }
//         req.user = user
//         next()
//     })
// }

router.post('/register', userController.register)
router.post('/login', userController.login)
router.get('/hospital/dashboard', userAuth.authenticateToken, dashboardController.hospital)
router.get('/patient/dashboard', userAuth.authenticateToken, dashboardController.patient)

module.exports = router