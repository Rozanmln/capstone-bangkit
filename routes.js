const express = require('express')
const router = express.Router()

router.get("/", (req, res) => {
    console.log("Response Success")
    res.send("Response Success!")
})

module.exports = router