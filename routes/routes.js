const express = require('express')
const router = express.Router()
const userController = require('../controller/userController')
const dashboardController = require('../controller/dashboardController')
const userAuth = require('../middleware/auth')

router.post('/register', userController.register)
router.post('/login', userController.login)
router.get('/hospital/dashboard', userAuth.authenticateToken, dashboardController.hospital)
router.get('/patient/dashboard', userAuth.authenticateToken, dashboardController.patient)
router.get('/patient/symptom', userAuth.authenticateToken, userController.symptom)
router.post('/patient/checkSymptom/:id', userAuth.authenticateToken, userController.checkSymptom)

module.exports = router