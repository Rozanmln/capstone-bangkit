const express = require('express')
const app = express()
const bodyParser = require('body-parser')

const router = require('./routes')

app.use(bodyParser.urlencoded({ extended: false }))
app.use(router)

const PORT = process.env.PORT || 5000
app.listen(PORT, () => {
    console.log("Server listening on " + PORT)
})