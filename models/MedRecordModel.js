const { Sequelize } = require("sequelize")
const db = require("../config/Database.js")
const Patient = require("./PatientModel.js")
const Hospital = require("./HospitalModel.js")

const { DataTypes } = Sequelize;

const MedRecord = db.define('medical_record', {
    mrid: {
        type: DataTypes.STRING,
        defaultValue: DataTypes.UUIDV4,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    patientName: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true,
        }
    },
    NIK: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true,
        }
    },
    body: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true,
        }
    },
    patientId: {
        type: DataTypes.INTEGER,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    hospitalId: {
        type: DataTypes.INTEGER,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    }
}, {
    freezeTableName: true
})

Patient.hasMany(MedRecord)
Hospital.hasMany(MedRecord)
MedRecord.belongsTo(Patient, { foreignKey: 'patientId' })
MedRecord.belongsTo(Hospital, { foreignKey: 'hospitalId' })

module.exports = MedRecord