import numpy as np
import random
import pickle
import warnings
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report
from sklearn.metrics import accuracy_score
from androguard.core.bytecodes.apk import APK
warnings.filterwarnings(action='ignore')

decisiontree = DecisionTreeClassifier(random_state=0)
pickle.dump(decisiontree, open('decisiontree_new.pkl', 'wb'))
def predict(apk):
  vector = {}
  a = APK(apk)
  perm = a.get_permissions()
  print(perm)
  for d in perms:
    if d in perm:
      vector[d]=1
    else:
      vector[d]=0
  input = [ v for v in vector.values() ]
  print(input)
  print('result :',decisiontree.predict([input]))