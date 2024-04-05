import socket
import json

if __name__ == '__main__':
    print('Client')
    SERVER_ADDR = ('127.0.0.1', 9190)
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client:
        client.connect(SERVER_ADDR)
        print('Server Connect')

        while True:
            input_tmp = input('Input Data:')
            data = {'Data': input_tmp}
            print("Client Send Data:{0}".format(data['Data']))
            
            client.sendall(json.dumps(data).encode('UTF-8'))
            data = client.recv(1024)
            data = json.loads(data)
            print("Server Receive Data:{0}" .format(data['Data']))

        