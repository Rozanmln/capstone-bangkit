const express = require("express")
const {
    createPatient,
    getPatient,
    getPatientById,
    updatePatient,
    deletePatient
} = require("../controllers/Patient")
const { authPatient, authToken, authHospital } = require("../middleware/Auth")

const router = express.Router()

router.get('/patient', authToken, authHospital, getPatient)
router.get('/patientbyid', authToken, authHospital, getPatientById)
router.post('/patient', createPatient)
router.patch('/patient', authToken, authPatient, updatePatient)
router.delete('/patient', authToken, authPatient, deletePatient)

module.exports = router