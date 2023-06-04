const express = require("express")
const { loginPatient, loginHospital, logout } = require("../controllers/Auth")

const router = express.Router()

router.post('/loginPatient', loginPatient)
router.post('/loginHospital', loginHospital)
router.post('/logout', logout)

module.exports = router