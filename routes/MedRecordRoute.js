const express = require("express")
const {
    createMedRecord,
    getMedRecordById,
    getMedRecord,
    updateMedRecord,
    deleteMedRecord
} = require("../controllers/MedRecord")
const { authHospital, authToken } = require("../middleware/Auth")

const router = express.Router()

router.get('/medRecord', authToken, authHospital, getMedRecord)
router.get('/medRecord/:id', authToken, authHospital, getMedRecordById)
router.post('/medRecord', authToken, authHospital, createMedRecord)
router.patch('/medRecord/:id', authToken, authHospital, updateMedRecord)
router.delete('/medRecord/:id', authToken, authHospital, deleteMedRecord)

module.exports = router