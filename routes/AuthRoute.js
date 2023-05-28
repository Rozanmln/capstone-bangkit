const express = require("express")
const { loginPatient, loginHospital } = require("../controllers/Auth")

const router = express.Router()

router.post('/loginPatient', loginPatient)
router.post('/loginHospital', loginHospital)

module.exports = router