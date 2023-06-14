const jwt = require('jsonwebtoken');
const { blacklistToken } = require('../controllers/Auth');

require('dotenv').config();
const secretKey = process.env.SECRET_KEY;

const authToken = (req, res, next) => {
  const authHeader = req.headers['authorization'];
  const token = authHeader && authHeader.split(' ')[1];
  if (token == null) {
    return res.sendStatus(401);
  }

  if (blacklistToken.includes(token)) {
    return res.status(401).json({ message: 'Token revoked' });
  }

  jwt.verify(token, secretKey, (err, user) => {
    if (err) {
      return res.sendStatus(403);
    }
    req.user = user;
    next();
  });
};

const authPatient = (req, res, next) => {
  const role = req.user.role;
  if (role !== '1') return res.status(401).json({ msg: 'Patient Only!' });
  next();
};

const authHospital = (req, res, next) => {
  const role = req.user.role;
  if (role !== '2') return res.status(401).json({ msg: 'Hospital Only!' });
  next();
};

module.exports = {
  authPatient,
  authHospital,
  authToken,
};
