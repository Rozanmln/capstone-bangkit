const express = require("express")
const router = express.Router()
const { predict,
    getPredict,
    getPredictById,
    deletePredict,
    getSymptom
} = require("../predict/predict")
const { authPatient, authToken } = require("../middleware/Auth")

router.get('/symptom', authToken, authPatient, getSymptom)

router.post('/predict', authToken, authPatient, predict)
router.get('/predict', authToken, authPatient, getPredict)
router.get('/predict/:id', authToken, authPatient, getPredictById)
router.delete('/predict/:id', authToken, authPatient, deletePredict)

module.exports = router