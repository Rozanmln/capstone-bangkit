package com.example.hereapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


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
@Parcelize
data class MedicalRecordDetail(
    val patientName: String,
    val NIK: String,
    val symptom: String,
    val diagnostic_results: String,
    val doctor_recommendation: String,
    val createdAt: String
): Parcelable

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

data class InfoPatientResponse(
    val pid: String,
    val username: String,
    val email: String,
    val NIK: String,
    val address: String
)

data class Symptom(
    val id: Int,
    val symptomName: String,
    val weight: Int,
    val createdAt: String,
    val updateAt: String
)
data class InputSymptom(
    var isChecked: Boolean = false,
    val symptom: Symptom? = null
)

data class PredictSymptom(
    val symptom: Int
)

@Parcelize
data class ResponsePredict(

    @field:SerializedName("objectWithId")
    val objectWithId: ObjectWithId? = null
):Parcelable

@Parcelize
data class ObjectWithId(

    @field:SerializedName("")
    val jsonMember: String? = null,

    @field:SerializedName("Precaution")
    val precaution: String? = null,

    @field:SerializedName("Description")
    val description: String? = null,

    @field:SerializedName("Disease")
    val disease: String? = null,

    @field:SerializedName("id")
    val id: String? = null
): Parcelable

