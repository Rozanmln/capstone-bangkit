const Hospital = require("../models/HospitalModel")
const bcrypt = require("bcrypt")

const createHospital = async (req, res) => {
    const { username, email, password, address, role } = req.body
    const salt = bcrypt.genSaltSync(10)
    const hashPass = await bcrypt.hashSync(password, salt)

    try {
        const response = await Hospital.findOne({
            where: {
                username: username
            }
        })

        if (response) return res.status(409).json({ message: 'hospital name already exists' })

        await Hospital.create({
            username: username,
            email: email,
            password: hashPass,
            address: address,
            role: role
        })
        res.status(201).json({ msg: "Register Berhasil" })
    } catch (error) {
        res.status(400).json({ msg: error.message })
    }
}

const getHospital = async (req, res) => {
    try {
        const response = await Hospital.findAll({
            attributes: ['hid', 'username', 'email', 'address', 'role']
        });
        res.status(200).json(response);
    } catch (error) {
        res.status(500).json({ msg: error.message })
    }
}

const getHospitalById = async (req, res) => {
    try {
        const response = await Hospital.findOne({
            attributes: ['hid', 'username', 'email', 'address', 'role'],
            where: {
                hid: req.params.id
            }
        });
        res.status(200).json(response)
    } catch (error) {
        res.status(500).json({ msg: error.message })
    }
}

const updateHospital = async (req, res) => {
    const { username, email, password, address, role } = req.body
    const user = await Hospital.findOne({
        where: {
            hid: req.params.id
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
        await Hospital.update({
            username: username,
            email: email,
            password: hashPass,
            address: address,
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

const deleteHospital = async (req, res) => {
    const user = await Hospital.findOne({
        where: {
            hid: req.params.id
        }
    });
    if (!user) return res.status(404).json({ msg: "User tidak ditemukan" })
    try {
        await Hospital.destroy({
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
    createHospital,
    getHospital,
    getHospitalById,
    updateHospital,
    deleteHospital
}