const { Sequelize } = require("sequelize")
const db = require("../config/Database.js")
const Patient = require("./PatientModel.js")

const { DataTypes } = Sequelize;

const Symptom = db.define('symptom', {
    symptomName: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    weight: {
        type: DataTypes.INTEGER,
        allowNull: false,
        validate: {
            notEmpty: true,
            isEmail: true
        }
    }
}, {
    freezeTableName: true
})

const CheckSymptom = db.define('check_symptom', {
    symptomName: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    patientId: {
        type: DataTypes.INTEGER,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    symptomId: {
        type: DataTypes.INTEGER,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    }
}, {
    freezeTableName: true
})

Patient.hasMany(CheckSymptom)
Symptom.hasMany(CheckSymptom)
CheckSymptom.belongsTo(Patient, { foreignKey: 'patientId' })
CheckSymptom.belongsTo(Symptom, { foreignKey: 'symptomId' })

module.exports = { Symptom, CheckSymptom }