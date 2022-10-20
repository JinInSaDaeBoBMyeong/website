import sklearn
import pickle
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.metrics import classification_report, confusion_matrix 
from sklearn.ensemble import RandomForestClassifier
from sklearn.tree import DecisionTreeClassifier
import xgboost as xgb
from xgboost import XGBClassifier
from androguard.core.bytecodes.apk import APK
import warnings
warnings.filterwarnings(action='ignore')

pe = []
with open('android_permissions.txt','r') as a:
  content = a.readlines()
  for line in content:
    cur_perm = line[:-1]
    pe.append(cur_perm)
    


# grid = pickle.load('svc_new.pkl')
with open('svc_new.pkl', 'rb') as file:
  grid = pickle.load(file)
  
with open('randomfrorest_new.pkl','rb') as file:
  rf = pickle.load(file)

with open('decisiontree_new.pkl','rb') as file:
  decisiontree= pickle.load(file)

def svm_predict(apk):
  vector = {}
  a = APK(apk)
  perm = a.get_permissions()
  for d in pe:
    if d in perm:
      vector[d]=1
    else:
      vector[d]=0
  input = [ v for v in vector.values() ]
  return grid.predict([input])

def rf_predict(apk):
  vector = {}
  a = APK(apk)
  perm = a.get_permissions()
  for d in pe:
    if d in perm:
      vector[d]=1
    else:
      vector[d]=0
  input = [ v for v in vector.values() ]
  return rf.predict([input])

def dec_predict(apk):
  vector = {}
  a = APK(apk)
  perm = a.get_permissions()
  for d in pe:
    if d in perm:
      vector[d]=1
    else:
      vector[d]=0
  input = [ v for v in vector.values() ]
  return decisiontree.predict([input])

# test
# malign apk
dec_predict('uploaded_files/sample.apk')
