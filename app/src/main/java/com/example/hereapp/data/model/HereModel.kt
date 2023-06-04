package com.example.hereapp.data.model


data class LoginRequest(
    val username: String,
    val password: String
)
data class LoginResponse(
    val message: String,
    val token: String
)
data class DataFeature(
    val imageUrl: String,
    val description: String
)

data class DataArticle(
    val imageUrl: String,
    val description: String,
)
data class MedicalRecord(
    val mrid: String,
    val patientName: String,
    val NIK: String,
    val diagnostic_results: String,
    val createdAt: String
)
data class MedicalRecordRequest(
    val patientName: String,
    val NIK: String,
    val symptom: String,
    val diagnostic_results: String,
    val doctor_recommendation: String
)
data class MedicalRecordDetail(
    val patientName: String,
    val NIK: String,
    val symptom: String,
    val diagnostic_results: String,
    val doctor_recommendation: String,
    val createdAt: String
)
data class UserSession(
    var isLogin: Boolean? = null,
    var name: String? = null,
    var token: String? = null,
    var role: Int? = null
)
data class RegisterHospitalRequest(
    var username: String,
    var email: String,
    var password: String,
    var address: String
)

data class Response(
    val msg: String
)

data class RegisterPatientRequest(
    val username: String,
    val email: String,
    val password: String,
    val NIK: String,
    val address: String
)

data class RegisterPatientResponse(
    val msg: String
)

data class InfoHospitalResponse(
    val hid: String,
    val username: String,
    val email: String,
    val address: String
)