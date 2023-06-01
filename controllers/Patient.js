const Patient = require("../models/PatientModel")
const bcrypt = require("bcrypt")

const createPatient = async (req, res) => {
    const { username, email, password, NIK, role } = req.body
    const salt = bcrypt.genSaltSync(10)
    const hashPass = await bcrypt.hashSync(password, salt)

    try {
        const response = await Patient.findOne({
            where: {
                username: username
            }
        })

        if (response) return res.status(409).json({ message: 'patient name already exists' })

        await Patient.create({
            username: username,
            email: email,
            password: hashPass,
            NIK: NIK,
            role: role
        })
        res.status(201).json({ msg: "Register Berhasil" })
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const getPatient = async (req, res) => {
    try {
        const response = await Patient.findAll({
            attributes: ['pid', 'username', 'email', 'NIK', 'role']
        });
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({ msg: error.message })
    }
}

const getPatientById = async (req, res) => {
    try {
        const response = await Patient.findOne({
            attributes: ['pid', 'username', 'email', 'NIK', 'role'],
            where: {
                pid: req.params.id
            }
        });
        res.status(200).json(response)
    } catch (error) {
        res.status(500).json({ msg: error.message })
    }
}

const updatePatient = async (req, res) => {
    const { username, email, password, NIK, role } = req.body
    const user = await Patient.findOne({
        where: {
            pid: req.params.id
        }
    });
    if (!user) return res.status(404).json({ msg: "User tidak ditemukan" })
    let hashPass
    let salt
    if (password === "" || password === null) {
        hashPass = user.password
    } else {
        salt = bcrypt.genSaltSync(10)
        hashPass = bcrypt.hashSync(password, salt)
    }

    try {
        await Patient.update({
            username: username,
            email: email,
            password: hashPass,
            NIK: NIK,
            role: role
        }, {
            where: {
                id: user.id
            }
        });
        res.status(200).json({ msg: "User Updated" });
    } catch (error) {
        res.status(400).json({ msg: error.message });
    }
}

const deletePatient = async (req, res) => {
    const user = await Patient.findOne({
        where: {
            pid: req.params.id
        }
    });
    if (!user) return res.status(404).json({ msg: "User tidak ditemukan" })
    try {
        await Patient.destroy({
            where: {
                id: user.id
            }
        });
        res.status(200).json({ msg: "User Deleted" })
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

module.exports = {
    createPatient,
    getPatient,
    getPatientById,
    updatePatient,
    deletePatient
}