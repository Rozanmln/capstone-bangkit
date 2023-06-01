const express = require("express")
const {
    getSymptom,
    checkSymptom
} = require("../controllers/Symptom")
const { authPatient, authToken } = require("../middleware/Auth")

const router = express.Router()

router.get('/getSymptom', authToken, authPatient, getSymptom)
router.post('/medRecord/:id', authToken, authPatient, checkSymptom)

module.exports = router