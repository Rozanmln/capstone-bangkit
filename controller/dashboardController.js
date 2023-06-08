const hospital = (req, res) => {
    // Check the role to ensure only patients can access this route
    if (req.user.role !== '2') {
        return res.status(403).json({ message: 'Access denied!' })
    }

    res.json({ message: 'Hospital Dashboard!' })
}
const patient = (req, res) => {
    // Check the role to ensure only patients can access this route
    if (req.user.role !== '1') {
        return res.status(403).json({ message: 'Access denied!' })
    }

    res.json({ message: 'Patient Dashboard!' })
}

module.exports = {
    hospital,
    patient
}