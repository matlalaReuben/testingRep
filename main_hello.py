import tkinter as tk
import mysql.connector as mysql
connection = mysql.connect( user="W39cSeLp8A", database="W39cSeLp8A", host="remotemysql.com", port="3306",password="6b2V9LddHa" )
mycursor = connection.cursor()
print( connection )
print( mycursor )
print("hello motherfuckers1")
