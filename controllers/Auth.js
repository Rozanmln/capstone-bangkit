const Patient = require("../models/PatientModel")
const Hospital = require("../models/HospitalModel")
const jwt = require('jsonwebtoken')
const bcrypt = require("bcrypt")

require('dotenv').config()
const secretKey = process.env.SECRET_KEY

const loginPatient = async (req, res) => {
    const { username, password } = req.body
    const user = await Patient.findOne({
        where: {
            username: username
        }
    })
    if (!user) return res.status(404).json({ msg: "User tidak ditemukan" })
    const match = bcrypt.compareSync(password, user.password)
    if (!match) return res.status(400).json({ msg: "Wrong Password" })
    const token = jwt.sign({ username, role: user.role, _id: user.id }, secretKey)
    res.status(200).json({ message: 'Login successful', token })
}
const loginHospital = async (req, res) => {
    const { username, password } = req.body
    const user = await Hospital.findOne({
        where: {
            username: username
        }
    })
    if (!user) return res.status(404).json({ msg: "User tidak ditemukan" })
    const match = await bcrypt.compareSync(password, user.password)
    if (!match) return res.status(400).json({ msg: "Wrong Password" })

    const token = jwt.sign({ username, role: user.role, _id: user.id }, secretKey)
    res.status(200).json({ message: 'Login successful', token })
}

module.exports = {
    loginPatient,
    loginHospital
}