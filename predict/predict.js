const tf = require('@tensorflow/tfjs')
const combinations = require("./combinations")
const Patient = require("../models/PatientModel")
const { Symptoms, Predicted } = require("../models/SymptomModel")
const { Op } = require("sequelize")


const predict = async (req, res) => {
    try {

        const jsonData = req.body

        const jsonString = JSON.stringify(jsonData);

        const model = await tf.loadLayersModel('https://storage.googleapis.com/modelml12/model.json')

        const arrayData = Object.values(jsonData)

        const numData = arrayData.map(str => parseInt(str))

        const data = Array.from({ length: 17 }, (value, index) =>
            index < numData.length ? numData[index] : 0
        )

        const inputTensor = tf.tensor([data])

        const prediction = model.predict(inputTensor)

        const predictionData = await prediction.data()

        const result = Array.from(predictionData)

        const predicted = argMax(result)

        const objectWithId = findObjectById(combinations, predicted)

        await Predicted.create({
            symptoms: jsonString,
            predictedId: objectWithId.id,
            disease: objectWithId.Disease,
            description: objectWithId.Description,
            precaution: objectWithId.Precaution,
            patientId: req.user._id
        })

        res.json({ objectWithId })

    } catch (error) {
        res.status(500).json({ msg: error.message })
    }

}

const getPredict = async (req, res) => {
    const patientId = req.user._id

    try {
        const result = await Predicted.findAll({
            attributes: ['prid', 'disease', 'description', 'precaution'],
            where: {
                patientId: patientId
            }
        })

        if (!result) {
            res.status(401).json({ message: 'There is no Predict Record yet' })
        } else {
            res.status(200).json(result);
        }
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const getPredictById = async (req, res) => {
    const patientId = req.user._id
    const predictId = req.params.id

    try {
        const result = await Predicted.findOne({
            attributes: ['prid', 'disease', 'description', 'precaution'],
            where: {
                [Op.and]: [{ patientId: patientId }, { prid: predictId }]
            }
        })
        res.status(200).json(result);
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const deletePredict = async (req, res) => {
    const patientId = req.user._id
    const predictId = req.params.id
    try {
        const user = await Predicted.destroy({
            where: {
                [Op.and]: [{ patientId: patientId }, { prid: predictId }]
            }
        })
        res.status(200).json({ msg: "Predict Record Deleted" });
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const getSymptom = async (req, res) => {
    try {
        const response = await Symptoms.findAll()
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({ msg: error.message })
    }
}

function argMax(array) {

    let maxValue = Math.max(...array)

    for (let i = 0; i < array.length; i++) {
        if (array[i] === maxValue) {
            return i
        }
    }

    return -1
}

function findObjectById(jsonObject, id) {
    for (let key in jsonObject) {
        if (jsonObject.hasOwnProperty(key) && jsonObject[key]["id"] == id) {
            return jsonObject[key]
        }
    }
    return null
}

module.exports = {
    predict,
    getPredict,
    getPredictById,
    deletePredict,
    getSymptom
}