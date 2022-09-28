import joblib
from pandas import pandas as pd
import csv

def malpermissionlist():
    with open('test_data_1.csv') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter = ',')
        list_of_column_names = []
        for row in csv_reader:
            list_of_column_names.append(row)
            break
        
    return list_of_column_names

def analyze(dataframe):
    dataframe = dataframe.sample(frac=1)
    dataframe = dataframe.drop(['label'], axis=1)
    model = joblib.load('test_model_1.pkl')
    result = model.predict(dataframe)
    for i in result:
        if i == 1: # Case Maliciouse
            print("Malicious")
            return True
        else:      # Case Benign
            print("Benign")
            return False

def testpredict():
    test_data = pd.read_csv("test_data_1.csv") # Load test dataset
    test_data = test_data.sample(frac=1) # Data random shuffle
    test_data = test_data.drop(['label'], axis=1) # Drop column' label' for predict

    model = joblib.load('test_model_1.pkl') # Load Model(test)
    result = model.predict(test_data) # Predict

    for i in result:
        if i == 1: # Case Maliciouse
            print("Malicious")
        else:      # Case Benign
            print("Benign")
            
            