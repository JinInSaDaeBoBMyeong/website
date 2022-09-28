import pymysql
import hashlib
 
class Myaccounts:
    def __init__(self):
        pass
    
    def select():
        ret = []
        db = pymysql.connect(host='localhost', user='kkm9734', db='malware', password='kkm97349734', charset='utf8')
        curs = db.cursor()
        
        sql = "select * from accounts";
        curs.execute(sql)
        
        rows = curs.fetchall()
        for e in rows:
            temp = {'idx':e[0],'id':e[1],'passwd':e[2],'email':e[3] }
            ret.append(temp)
        
        db.commit()
        db.close()
        return ret
    
    def insert(id, passwd, email):
        db = pymysql.connect(host='localhost', user='kkm9734', db='malware', password='kkm97349734', charset='utf8')
        curs = db.cursor()
        
        sql = '''insert into accounts (id, passwd, email) values(%s,%s,%s)'''
        enc = hashlib.md5()
        enc.update(passwd.encode('utf-8'))
        encText = enc.hexdigest()
        curs.execute(sql,(id, encText, email))
        db.commit()
        db.close()
    
    def update(self, id, passwd, email): 
        db = pymysql.connect(host='localhost', user='kkm9734', db='malware', password='kkm97394734', charset='utf8')
        curs = db.cursor()
        
        sql = "update accounts set passwd=%s, email=%s where id=%s"
        curs.execute(sql,(passwd, email,id))
        db.commit()
        db.close()
        
    def delete(self, id):
        db = pymysql.connect(host='localhost', user='kkm9734', db='malware', password='kkm97394734', charset='utf8')
        curs = db.cursor()
        
        sql = "delete from accounts where id=%s"
        curs.execute(sql,id)
        db.commit()
        db.close()
    