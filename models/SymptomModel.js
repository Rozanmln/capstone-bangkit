const { Sequelize } = require("sequelize")
const db = require("../config/Database.js")
const Patient = require("./PatientModel.js")

const { DataTypes } = Sequelize;

const Symptoms = db.define('symptoms', {
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

const Predicted = db.define('predicted', {
    prid: {
        type: DataTypes.STRING,
        defaultValue: DataTypes.UUIDV4,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    symptoms: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    predictedId: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    disease: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    description: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            notEmpty: true
        }
    },
    precaution: {
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
    }
}, {
    freezeTableName: true
})

Patient.hasMany(Predicted)
Predicted.belongsTo(Patient, { foreignKey: 'patientId' })

module.exports = { Symptoms, Predicted }