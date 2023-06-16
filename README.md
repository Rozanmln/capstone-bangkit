# Cloud Computing
Our task is to create Restful APIs for the app and deploy it to **Google Cloud Platform**. The service that we use is **Cloud Run** for communication between user and mobile development in medical record feature and also for machine learning prediction system and mobile development in diseases prediction feature. And also **Cloud Build** for implementation of CI/CD in our development system by developer. Using **Cloud storage** to store our machine learning model and **Cloud SQL** for our database   

# Restful APIs
We use **Javascript** language and **Node.js** framework to build the APIs. And also **Sequelize** library to implementing ORM (Object-Relational Mapping) in our database. Each URL will be explained below

Postman Collection for Testing : 
https://drive.google.com/file/d/1Vw9MOTP0lS1euSkLtOYAYfwFO3NykvGl/view?usp=sharing

# Patient Routes
in this section there are endpoint routes for user that have patient role. The response from each route is JSON format

Base URL :
> https://here-app-ripfuystpa-uc.a.run.app

### Register Patient
Path :
> /patient
> 
> https://here-app-ripfuystpa-uc.a.run.app/patient

Method :
> POST

Request Body : 
* username as string, 5-20 karakter
* email as string, format email
* password as string
* NIK as string
* address as string

```json
{
  "msg" : "Register Berhasil"
}
```

### Show Patient
Path :
> /patient
> 
> https://here-app-ripfuystpa-uc.a.run.app/patient

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "pid": "a7c1ac36-9b59-480c-ad1c-ddd2bec40d6c",
  "username": "citra",
  "email": "citra@gmail.com",
  "NIK": "12345678",
  "address": "Jl.Madrasah II"
}
```

### Show Patient by ID
Path :
> /patientbyid
> 
> https://here-app-ripfuystpa-uc.a.run.app/patientbyid

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "pid": "a7c1ac36-9b59-480c-ad1c-ddd2bec40d6c",
  "username": "citra",
  "email": "citra@gmail.com",
  "NIK": "12345678",
  "address": "Jl.Madrasah II"
}
```

### Edit Patient
Path :
> /patient
> 
> https://here-app-ripfuystpa-uc.a.run.app/patient

Method :
> PATCH

Header :
> Authorization : Bearer token

Request Body : 
* username as string, 5-20 karakter
* email as string, format email
* password as string
* NIK as string
* address as string

```json
{
  "msg": "User Updated"
}
```

### Delete Patient
Path :
> /patient
> 
> https://here-app-ripfuystpa-uc.a.run.app/patient

Method :
> DELETE

Header :
> Authorization : Bearer token

```json
{
  "msg": "User Deleted"
}
```

# Hospital Routes
in this section there are endpoint routes for user that have hospital role. The response from each route is JSON format

Base URL :
> https://here-app-ripfuystpa-uc.a.run.app

### Register Patient
Path :
> /hospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/hospital

Method :
> POST

Request Body : 
* username as string, 5-20 karakter
* email as string, format email
* password as string
* address as string

```json
{
  "msg" : "Register Berhasil"
}
```

### Show Hospital
Path :
> /hospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/hospital

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "hid": "a2dddd4c-bb76-4dae-ab74-2f13a28c4c3b",
  "username": "RS UI",
  "email": "rsui@gmail.com",
  "address": "Jl. madrasah"
}
```

### Show Patient by ID
Path :
> /hospitalbyid
> 
> https://here-app-ripfuystpa-uc.a.run.app/hospitalbyid

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "hid": "a2dddd4c-bb76-4dae-ab74-2f13a28c4c3b",
  "username": "RS UI",
  "email": "rsui@gmail.com",
  "address": "Jl. madrasah"
}
```

### Edit Patient
Path :
> /hospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/hospital

Method :
> PATCH

Header :
> Authorization : Bearer token

Request Body : 
* username as string, 5-20 karakter
* email as string, format email
* password as string
* address as string

```json
{
  "msg": "User Updated"
}
```

### Delete Patient
Path :
> /hospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/hospital

Method :
> DELETE

Header :
> Authorization : Bearer token

```json
{
  "msg": "User Deleted"
}
```

# Authorization Routes
in this section there are endpoint routes for accessing app authorization. The response from each route is JSON format

Base URL :
> https://here-app-ripfuystpa-uc.a.run.app

### Login Patient
Path :
> /loginPatient
> 
> https://here-app-ripfuystpa-uc.a.run.app/loginPatient

Method :
> POST

Request Body : 
* username as string, 5-20 karakter
* password as string

```json
{
  "message": "Login successful",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNpdHJhIiwicm9sZSI6IjEiLCJfaWQiOjEsImlhdCI6MTY4NTM3MDIxMn0.bisS3LKvl4uMlePpyeaALhlpjd0UpLwIDh6rCsLahx0"
}
```

### Login Hospital
Path :
> /loginHospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/loginHospital

Method :
> POST

Request Body : 
* username as string, 5-20 karakter
* password as string

```json
{
  "message": "Login successful",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IlJTIFVJIiwicm9sZSI6IjIiLCJfaWQiOjEsImlhdCI6MTY4NTM3MDIyMX0.j9esKpnOFJOJ1TEcFd6kUHd9PxPMQmxlrcyvsqle-Vc"
}
```

### Logout
Path :
> /logout
> 
> https://here-app-ripfuystpa-uc.a.run.app/logout

Method :
> POST

```json
{
  "message": "Logout successful."
}
```

# Medical Record Routes
in this section there are endpoint routes for medical record feature that can store and show patient medical record. The response from each route is JSON format

Base URL :
> https://here-app-ripfuystpa-uc.a.run.app

### Create Medical Record
Path :
> /medRecord
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecord

Method :
> POST

Header :
> Authorization : Bearer token

Request Body : 
* patientName as string
* NIK as string
* symptom as string
* diagnostic_results as string
* doctor_recommendation as string

```json
{
  "msg": "Create Medical Record Successfully"
}
```

### Search Medical Record for Hospital
Path :
> /searchMedRecordforHospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/searchMedRecordforHospital

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/searchMedRecordforHospital?input=rozan

Method :
> GET

Header :
> Authorization : Bearer token

Request Query : 
* input as string

```json
{
  {
        "mrid": "a9509316-ada4-4dab-b08f-fbb572e82abb",
        "patientName": "rozan",
        "NIK": "121212",
        "diagnostic_results": "alergi debu",
        "createdAt": "2023-05-31T19:07:32.000Z"
    }

}
```

### Search Medical Record for Patient
Path :
> /searchMedRecordforPatient
> 
> https://here-app-ripfuystpa-uc.a.run.app/searchMedRecordforPatient

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/searchMedRecordforPatient?input=alergi

Method :
> GET

Header :
> Authorization : Bearer token

Request Query : 
* input as string

```json
{
  {
        "mrid": "90ee682a-3f39-4431-9fa7-1790fea6adba",
        "patientName": "rozan",
        "NIK": "151515",
        "diagnostic_results": "alergi",
        "createdAt": "2023-06-10T03:52:54.000Z"
    }
}
```

### Show Medical Record for hospital
Path :
> /medRecordforHospital
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecordforHospital

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  {
        "mrid": "6b5b4b10-33c8-4549-96a3-0a2b8637288a",
        "patientName": "citra",
        "NIK": "131313",
        "diagnostic_results": "demam disebabkan oleh diare iritasi lambung",
        "createdAt": "2023-06-03T16:54:36.000Z"
    }

}
```

### Show Medical Record for patient
Path :
> /medRecordforPatient
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecordforPatient

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  {
        "mrid": "6b5b4b10-33c8-4549-96a3-0a2b8637288a",
        "patientName": "citra",
        "NIK": "131313",
        "diagnostic_results": "demam disebabkan oleh diare iritasi lambung",
        "createdAt": "2023-06-03T16:54:36.000Z"
    }

}
```

### Show Medical Record by ID for hospital
Path :
> /medRecordforHospital/:id
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecordforHospital/{id}

Example Request : 
> hhttps://here-app-ripfuystpa-uc.a.run.app/medRecordforHospital/1

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "mrid": "6b5b4b10-33c8-4549-96a3-0a2b8637288a",
    "patientName": "citra",
    "NIK": "131313",
    "symptom": "panas suhu tubuh, meriang,  mual",
    "diagnostic_results": "demam disebabkan oleh diare iritasi lambung",
    "doctor_recommendation": "kurangi makan pedas, minum obat, istirahat, dan banyak minum air putih",
    "createdAt": "2023-06-03T16:54:36.000Z"
}
```

### Show Medical Record by ID for patient
Path :
> /medRecordforPatient/:id
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecordforPatient/{id}

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/medRecordforPatient/1

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "mrid": "6b5b4b10-33c8-4549-96a3-0a2b8637288a",
    "patientName": "citra",
    "NIK": "131313",
    "symptom": "panas suhu tubuh, meriang,  mual",
    "diagnostic_results": "demam disebabkan oleh diare iritasi lambung",
    "doctor_recommendation": "kurangi makan pedas, minum obat, istirahat, dan banyak minum air putih",
    "createdAt": "2023-06-03T16:54:36.000Z"
}
```

### Edit Medical Record
Path :
> /medRecord/:id
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecord/{id}

Method :
> PATCH

Header :
> Authorization : Bearer token

Request Body : 
* patientName as string
* NIK as string
* symptom as string
* diagnostic_results as string
* doctor_recommendation as string

```json
{
  "msg": "Medical Record Updated"
}
```

### Delete Medical Record
Path :
> /medRecord/:id
> 
> https://here-app-ripfuystpa-uc.a.run.app/medRecord/{id}

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/medRecord/1

Method :
> DELETE

Header :
> Authorization : Bearer token

```json
{
  "msg": "Medical Record Deleted"
}
```

# Diseases Predict Routes
in this section there are endpoint routes for disease predict feature that can receive input symptom from user and use machine learning model to predict the disease. The response from each route is JSON format

Base URL :
> https://here-app-ripfuystpa-uc.a.run.app

### Create Diseases Predict
Path :
> /predict
> 
> https://here-app-ripfuystpa-uc.a.run.app/predict

Method :
> POST

Header :
> Authorization : Bearer token

Request Body : 
* Symptoms as json

```json
{
  "objectWithId": {
        "": "22",
        "id": "22",
        "Disease": "Varicose veins",
        "Description": "A vein that has enlarged and twisted, often appearing as a bulging, blue blood vessel that is clearly visible through the skin. Varicose veins are most common in older adults, particularly women, and occur especially on the legs.",
        "Precaution": "lie down flat and raise the leg high, use oinments, use vein compression, dont stand still for long"
    }
}
```

### Show Diseases Predict
Path :
> /predict
> 
> https://here-app-ripfuystpa-uc.a.run.app/predict

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  {
        "prid": "ffebf257-bc67-4127-8154-6da7b3302fb5",
        "symptoms": "{\"input2\":\"4\",\"input3\":\"5\",\"input5\":\"5\"}",
        "disease": "Allergy",
        "description": "An allergy is an immune system response to a foreign substance that's not typically harmful to your body.They can include certain foods, pollen, or pet dander. Your immune system's job is to keep you healthy by fighting harmful pathogens.",
        "createdAt": "2023-06-08T07:02:09.000Z"
    },
    {
        "prid": "2046a328-393b-4b87-bbaf-595d4578b167",
        "symptoms": "{\"input2\":\"4\",\"input3\":\"5\",\"input4\":\"4\",\"input5\":\"5\"}",
        "disease": "Dimorphic hemorrhoids (piles)",
        "description": "Hemorrhoids, also spelled haemorrhoids, are vascular structures in the anal canal. In their ... Other names, Haemorrhoids, piles, hemorrhoidal disease .",
        "createdAt": "2023-06-08T07:02:21.000Z"
    },
}
```

### Show Diseases Predict by ID
Path :
> /predict/:id
> 
> https://here-app-ripfuystpa-uc.a.run.app/predict/{id}

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/predict/1

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  "prid": "eaf3f84a-f2ad-433d-ad8e-00cf2efa3945",
    "symptoms": "{\"input2\":\"6\",\"input3\":\"5\",\"input4\":\"4\",\"input6\":\"5\"}",
    "disease": "Cervical spondylosis",
    "description": "Cervical spondylosis is a general term for age-related wear and tear affecting the spinal disks in your neck. As the disks dehydrate and shrink, signs of osteoarthritis develop, including bony projections along the edges of bones (bone spurs).",
    "precaution": "use heating pad or cold pack, exercise, take otc pain reliver, consult doctor",
    "createdAt": "2023-06-09T14:59:13.000Z"
}
```

### Search Diseases Predict
Path :
> /searchPredict
> 
> https://here-app-ripfuystpa-uc.a.run.app/searchPredict

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/searchPredict?input=cervical

Method :
> GET

Header :
> Authorization : Bearer token

Request Query : 
* input as string

```json
{
  {
        "prid": "eaf3f84a-f2ad-433d-ad8e-00cf2efa3945",
        "symptoms": "{\"input2\":\"6\",\"input3\":\"5\",\"input4\":\"4\",\"input6\":\"5\"}",
        "disease": "Cervical spondylosis",
        "description": "Cervical spondylosis is a general term for age-related wear and tear affecting the spinal disks in your neck. As the disks dehydrate and shrink, signs of osteoarthritis develop, including bony projections along the edges of bones (bone spurs).",
        "createdAt": "2023-06-09T14:59:13.000Z"
    }
}
```

### Delete Diseases Predict
Path :
> /predict/:id
> 
> https://here-app-ripfuystpa-uc.a.run.app/predict/{id}

Example Request : 
> https://here-app-ripfuystpa-uc.a.run.app/predict/1

Method :
> DELETE

Header :
> Authorization : Bearer token

```json
{
  "msg": "Predict Record Deleted"
}
```

### Show Symptom
Path :
> /symptom
> 
> https://here-app-ripfuystpa-uc.a.run.app/symptom

Method :
> GET

Header :
> Authorization : Bearer token

```json
{
  {
        "id": 1,
        "symptomName": "itching",
        "weight": 1,
        "createdAt": "2023-06-06T11:49:13.000Z",
        "updatedAt": "2023-06-06T11:49:13.000Z"
    },
    {
        "id": 2,
        "symptomName": "skin_rash",
        "weight": 3,
        "createdAt": "2023-06-06T11:49:14.000Z",
        "updatedAt": "2023-06-06T11:49:14.000Z"
    },
………
}
```
