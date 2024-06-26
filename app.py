import os
import argparse

from flask import Flask
from flask_cors import CORS
from flask_ngrok import run_with_ngrok

from backend.routes import set_routes
from backend.constants import UPLOAD_FOLDER, CSV_FOLDER, DETECTION_FOLDER, SEGMENTATION_FOLDER, METADATA_FOLDER

parser = argparse.ArgumentParser('Online Food Recognition')
parser.add_argument('--ngrok', action='store_true',
                    default=False, help="Run on local or ngrok")
parser.add_argument('--host',  type=str,
                    default='172.29.192.1:5000', help="MoonSung IP")
parser.add_argument('--debug', action='store_true',
                    default=False, help="Run app in debug mode")


app = Flask(__name__, template_folder='templates', static_folder='static')
CORS(app, resources={r"/api/*": {"origins": "*"}})

app.config['SEND_FILE_MAX_AGE_DEFAULT'] = 1
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
app.config['CSV_FOLDER'] = CSV_FOLDER
app.config['DETECTION_FOLDER'] = DETECTION_FOLDER
app.config['SEGMENTATION_FOLDER'] = SEGMENTATION_FOLDER

set_routes(app)

if __name__ == '__main__':
    if not os.path.exists(UPLOAD_FOLDER):
        os.makedirs(UPLOAD_FOLDER, exist_ok=True)
    if not os.path.exists(DETECTION_FOLDER):
        os.makedirs(DETECTION_FOLDER, exist_ok=True)
    if not os.path.exists(SEGMENTATION_FOLDER):
        os.makedirs(SEGMENTATION_FOLDER, exist_ok=True)
    if not os.path.exists(CSV_FOLDER):
        os.makedirs(CSV_FOLDER, exist_ok=True)
    if not os.path.exists(METADATA_FOLDER):
        os.makedirs(METADATA_FOLDER, exist_ok=True)

    args = parser.parse_args()

    if args.ngrok:
        run_with_ngrok(app)
        app.run()
    else:
        # 기존 코드에서 host 값을 MoonSung IP로 설정
        host = '172.29.192.1'

        # 기존 코드에서 host 변수를 string으로 정의하고 있으므로 이를 고려하여 수정
        app.run(host=host, port=4000, debug=args.debug, use_reloader=False, ssl_context='adhoc')

