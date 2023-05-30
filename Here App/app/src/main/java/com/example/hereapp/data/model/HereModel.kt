package com.example.hereapp.data.model

data class DataFeature(
    val imageUrl: String,
    val description: String
)

data class DataArticle(
    val imageUrl: String,
    val description: String,
)

data class RegisterHospitalRequest(
    val Username: String,
    val Email: String,
    val Password: String,
    val Address: String
)

data class RegisterHospitalResponse(
    val msg: String
)

data class RegisterPatientRequest(
    val Username: String,
    val Email: String,
    val Password: String,
    val NIK: String
)

data class RegisterPatientResponse(
    val msg: String
)