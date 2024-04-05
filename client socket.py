from socket import *
import os
import sys

print('Client')
clientSock = socket(AF_INET, SOCK_STREAM)
clientSock.connect(('127.0.0.1', 9190))

print('Server Connect')
filename = input('Input FILE:')
clientSock.sendall(filename.encode('UTF-8'))

data = clientSock.recv(1024)

if not data:
    print('%s FILE NO Exist!')
    sys.exit()

nowdir = os.getcwd()
with open(nowdir+"\\"+filename, 'wb') as f:
    try:
        while data:
            f.write(data) 
            data = clientSock.recv(1024)
    except Exception as ex:
        print(ex)
print('%s FILE Transfer SUCCESS!' %(filename))