const express = require('express');
const {
  createHospital,
  getHospital,
  getHospitalById,
  updateHospital,
  deleteHospital,
} = require('../controllers/Hospital');
const { authHospital, authToken } = require('../middleware/Auth');

const router = express.Router();

router.get('/hospital', authToken, authHospital, getHospital);
router.get('/hospitalbyid', authToken, authHospital, getHospitalById);
router.post('/hospital', createHospital);
router.patch('/hospital', authToken, authHospital, updateHospital);
router.delete('/hospital', authToken, authHospital, deleteHospital);

module.exports = router;
