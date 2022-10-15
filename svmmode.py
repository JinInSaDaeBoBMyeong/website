import sklearn
import pickle
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.metrics import classification_report, confusion_matrix 
from androguard.core.bytecodes.apk import APK
import warnings
warnings.filterwarnings(action='ignore')

default = open('/content/drive/My Drive/android_permissions.txt','r').readlines()
perms = [s.rstrip('\n') for s in default]
for p in permissions:
  if p not in perms:
    perms.append(p)
print(len(perms))

with open('use_permissions.txt','w+') as f:
  for p in perms:
    f.write(p + '\n')

pe = []
with open('use_permissions.txt','r') as a:
  content = a.readlines()
  for line in content:
    cur_perm = line[:-1]
    pe.append(cur_perm)
    
Y = dataset_df['class']
X = dataset_df.drop(['class'], axis=1)

X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.2)

# defining parameter range  - 후에 더 정밀한 값 넣기
param_grid = {'C': [0.1, 1, 10, 100, 1000], 
			'gamma': [1, 0.1, 0.01, 0.001, 0.0001], 
			'kernel': ['rbf']} 

grid = GridSearchCV(SVC(), param_grid, refit = True, verbose = 1) 

# fitting the model for grid search 
grid.fit(X_train, y_train) 
print(grid.best_params_) 

# predict
grid_predictions = grid.predict(X_test) 

# print classification report 
print(classification_report(y_test, grid_predictions)) 
pickle.dump(grid, open('svc_new.pkl', 'wb'))

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
  print('result :', grid.predict([input]))

# test
# malign apk
predict('uploaded_files/sample2.apk')
# benign apk
