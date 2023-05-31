const MedRecord = require("../models/MedRecordModel")
const Patient = require("../models/PatientModel")
const { Op } = require("sequelize")

const createMedRecord = async (req, res) => {
    const hospitalId = req.user._id
    const { patientName, NIK, symptom, diagnostic_results, doctor_recommendation } = req.body

    try {
        const user = await Patient.findOne({
            attributes: ['id'],
            where: {
                NIK: NIK
            }
        })

        if (!user) {
            return res.status(500).json({ message: 'Internal server error' })
        } else {
            await MedRecord.create({
                patientName: patientName,
                NIK: NIK,
                symptom: symptom,
                diagnostic_results: diagnostic_results,
                doctor_recommendation: doctor_recommendation,
                patientId: user.id,
                hospitalId: hospitalId
            })
            res.status(201).json({ msg: "Create Medical Record Successfully" })
        }

    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}
const getMedRecord = async (req, res) => {
    const hospitalId = req.user._id

    try {
        const user = await MedRecord.findAll({
            attributes: ['patientName', 'NIK', 'diagnostic_results'],
            where: {
                hospitalId: hospitalId
            }
        })

        if (!user) {
            res.status(401).json({ message: 'There is no Medical Record yet' })
        } else {
            res.status(200).json(user);
        }
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const getMedRecordById = async (req, res) => {
    const hospitalId = req.user._id
    const medRecordId = req.params.id

    try {
        const user = await MedRecord.findOne({
            attributes: ['patientName', 'NIK', 'symptom', 'diagnostic_results', 'doctor_recommendation'],
            where: {
                [Op.and]: [{ hospitalId: hospitalId }, { mrid: medRecordId }]
            }
        })
        res.status(200).json(user);
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const updateMedRecord = async (req, res) => {
    const hospitalId = req.user._id
    const medRecordId = req.params.id
    const { patientName, NIK, symptom, diagnostic_results, doctor_recommendation } = req.body

    try {
        await MedRecord.update({
            patientName: patientName,
            NIK: NIK,
            symptom: symptom,
            diagnostic_results: diagnostic_results,
            doctor_recommendation: doctor_recommendation,
        }, {
            attributes: ['patientName', 'NIK', 'symptom', 'diagnostic_results', 'doctor_recommendation'],
            where: {
                [Op.and]: [{ hospitalId: hospitalId }, { mrid: medRecordId }]
            }
        })
        res.status(200).json({ msg: "Medical Record Updated" });
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }

}
const deleteMedRecord = async (req, res) => {
    const hospitalId = req.user._id
    const medRecordId = req.params.id
    try {
        const user = await MedRecord.destroy({
            where: {
                [Op.and]: [{ hospitalId: hospitalId }, { mrid: medRecordId }]
            }
        })
        res.status(200).json({ msg: "Medical Record Deleted" });
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

module.exports = {
    createMedRecord,
    getMedRecord,
    getMedRecordById,
    updateMedRecord,
    deleteMedRecord
}