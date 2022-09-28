import os
#import getplot
from flask import Flask, request, redirect, url_for,render_template, flash
from werkzeug.utils import secure_filename
import plotly.graph_objects as go
import plotly.offline as pyo
from myaccounts import Myaccounts
import andro as a
import modeltest as m
import pandas as pd

UPLOAD_FOLDER = 'uploaded_files'
TABLE_FOLDER = 'uploaded_tables'
ALLOWED_EXTENSIONS = set(['txt','apk'])

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
app.config['TABLE_FOLDER'] = TABLE_FOLDER
app.secret_key="it3rNull_secret_key"

@app.route('/')
def hello_world():
    return render_template('index.html')

@app.route('/table')
def table():
    return render_template('table.html')

@app.route('/save_table', methods=['GET', 'POST'])
def save_table():
    if request.method == 'POST':
        file = request.form['data']
        path = app.config['TABLE_FOLDER']   
        file_list = os.listdir(path)
        print(file_list)
        print(len(file_list))
        f = open(os.path.join(path, str(len(file_list))+'.txt'),'w')
        f.write(file)
        f.close()
        return redirect('/')
    return redirect('/')

def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1] in ALLOWED_EXTENSIONS

@app.route('/upload', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        file = request.files['malwares']
        if file and allowed_file(file.filename):
            filename = secure_filename(file.filename)
            file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
            return redirect('/analyze/'+filename)
    return redirect('/')

@app.route('/analyze/<filename>')
def analyze(filename):
    perm_csv = []
    for perm in m.malpermissionlist()[0]:
        if perm in a.dump_permissions(f"uploaded_files/%s" % filename):
            perm_csv.append(1)
        else:
            perm_csv.append(0)
    products_list = [perm_csv]
    df = pd.DataFrame (products_list, columns = m.malpermissionlist()[0])
    res = m.analyze(df)
    if res:
        return redirect('/#malicious')
    else:
        return redirect('/#benign')
        
    

@app.route('/draw', methods=['GET', 'POST'])
def draw():
    if request.method == 'POST':
        virus = request.form["ma1"]
        ransomware = request.form["ma2"]
        troijan = request.form["ma3"]
        spyware = request.form["ma4"]
        backdoor = request.form["ma5"]
        return render_template('index.html',plot=draw_plot(virus,ransomware,troijan,spyware,backdoor))
    return redirect('/')       

@app.route('/accounts')
def accounts():
     accountlist = Myaccounts.select();
     return render_template('accounts.html',accountlist = accountlist)
     print(accountlist)
     
@app.route('/register_execute', methods=['GET', 'POST'])
def register_execute():
    if request.method == 'POST':
        id = request.form["id"]
        passwd1 = request.form["passwd1"]
        passwd2 = request.form["passwd2"]
        email = request.form["email"]
        if(passwd1 == passwd2):
            print('hi')
            Myaccounts.insert(id,passwd1,email)
        return redirect('/accounts')
    return redirect('/accounts')  

def draw_plot(m1,m2,m3,m4,m5):
    categories = ['virus','ransomware','troijan','spyware','backdoor']
    categories = [*categories, categories[0]]
    grade1 = [int(m1), int(m2),int(m3),int(m4),int(m5)]
    grade1 = [*grade1, grade1[0]]
    fig = go.Figure(
        data=[
            go.Scatterpolar(r=grade1, theta=categories, fill='toself', name='Student1')
        ],
        layout=go.Layout(
            title=go.layout.Title(text='Grade'),
            polar={'radialaxis': {'visible': True}},
            showlegend=True
        )
    )
    return str(fig.to_json())
















if __name__ == '__main__':
    app.run(host='0.0.0.0',port=80)