# Machine Learning

## Description
Diseases Prediction is used to predict diseases that can be done independently by the user. Users only need to enter the symptoms they experience into the disease prediction feature and our application will directly make predictions based on the symptoms they input.

## Prediction System
The first step we took was to find data that was suitable for our needs, then we found some data, which consisted of data on diseases and their symptoms, as many as 17 symptoms, then data on disease symptoms and their weights, then descriptions of diseases and disease precautions. The data we found is in .csv format.

Data preprocessing steps:
1. Combine symptom data and symptom severity data by replacing all the symptoms in the disease dataset table into the weight of these symptoms
2. Unite the symptom dataset and its weight with the disease description dataset and diseases precautions using id in the diseases column
3. Make the combined table a combination.csv that contains 'Diseases', 'Description', and 'Precaution' column (https://github.com/Rozanmln/capstone-bangkit/blob/Machine-Learning/combination.csv)
4. Perform data normalization

## Modeling
To create our model using the Keras library from tensorflow, a model is generated like the following image:
<img width="412" alt="image" src="https://github.com/Rozanmln/capstone-bangkit/assets/84652339/a05bc4d1-396f-4ab6-a798-0b8988d70828">

With the following accuracy:
<img width="469" alt="image" src="https://github.com/Rozanmln/capstone-bangkit/assets/84652339/74541f33-b797-442b-aae1-8cc0cde54ca1">

Once the model is ready, we convert the model into model.json format so that it can be used by cloud computing for the deployment process
