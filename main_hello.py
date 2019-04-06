import tkinter as tk
import mysql.connector as mysql
connection = mysql.connect( user=self.user, database=self.database, host=self.host, port=self.port,password=self.password )
mycursor = self.connection.cursor()
print( connection )
print( mycursor )
print("hello world")
