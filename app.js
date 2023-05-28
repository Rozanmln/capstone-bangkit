const express = require("express")
const db = require("./config/Database")
const bodyParser = require("body-parser")
const PatientRoute = require("./routes/PatientRoute")
const HospitalRoute = require("./routes/HospitalRoute")
const MedRecordRoute = require("./routes/MedRecordRoute")
const AuthRoute = require("./routes/AuthRoute")

const app = express();

// (async () => {
//     await db.sync();
// })();

app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())
app.use(PatientRoute)
app.use(HospitalRoute)
app.use(MedRecordRoute)
app.use(AuthRoute)


const PORT = process.env.PORT || 5000
app.listen(PORT, () => {
    console.log("Server listening on " + PORT)
})