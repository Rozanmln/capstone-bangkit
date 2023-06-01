const Patient = require("../models/PatientModel")
const { Symptom, CheckSymptom } = require("../models/SymptomModel")
const { Op } = require("sequelize")

const getSymptom = async (req, res) => {
    try {
        const response = await Symptom.findAll({
            attributes: ['symptomName']
        })
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({ msg: error.message })
    }
}
const checkSymptom = async (req, res) => {
    const patientId = req.user._id
    const { symptomName, symptomId } = req.body

    try {
        const user = await Patient.findOne({
            attributes: ['id'],
            where: {
                id: patientId
            }
        })

        if (!user) {
            return res.status(500).json({ message: 'Internal server error' })
        } else {
            await CheckSymptom.create({
                symptomName: symptomName,
                patientId: user.id,
                symptomId: symptomId
            })
            res.status(201).json({ msg: "Create check symptom Successfully" })
        }

    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

module.exports = {
    getSymptom,
    checkSymptom
}