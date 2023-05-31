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
router.get('/patient/:id', authToken, authPatient, getPatientById)
router.post('/patient', createPatient)
router.patch('/patient/:id', authToken, authPatient, updatePatient)
router.delete('/patient/:id', authToken, authPatient, deletePatient)

module.exports = router