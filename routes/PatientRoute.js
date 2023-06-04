const express = require("express")
const {
    createPatient,
    getPatient,
    getPatientById,
    updatePatient,
    deletePatient
} = require("../controllers/Patient")
const { authPatient, authToken } = require("../middleware/Auth")

const router = express.Router()

router.get('/patient', authToken, authPatient, getPatient)
router.get('/patientbyid', authToken, authPatient, getPatientById)
router.post('/patient', createPatient)
router.patch('/patient', authToken, authPatient, updatePatient)
router.delete('/patient', authToken, authPatient, deletePatient)

module.exports = router