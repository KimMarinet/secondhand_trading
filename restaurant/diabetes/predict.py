import os
import sys
import json
import pickle
import numpy as np
from sklearn.linear_model import SGDClassifier
from sklearn.preprocessing import StandardScaler

# 입력 데이터 처리
#data = '[[0.0, 1.72, 0.0, 0.0, 0.0, 14.03, 3.5, 90.0], [0.0, 67.0, 0.0, 0.0, 5.0, 35.84, 3.5, 100.0], [0.0, 56.0, 1.0, 0.0, 4.0, 26.07, 5.0, 100.0], [0.0, 48.0, 0.0, 0.0, 0.0, 27.32, 6.5, 155.0], [1.0, 41.0, 0.0, 0.0, 4.0, 27.32, 4.5, 100.0]]'

if len(sys.argv) < 2:
    sys.exit(-1)

data = np.array(json.loads(sys.argv[1]))

# 기준 경로
base_path = os.path.dirname(os.path.realpath(__file__)) + "/"

# 모델과 Scaler 불러오기
with open(base_path + "model.pkl", "rb") as f:
    model = pickle.load(f)

with open(base_path + "scaler.pkl", "rb") as f:
    scaler = pickle.load(f)

# 모델 예측
data_scaled = scaler.transform(data)
predictions = model.predict(data_scaled)

print(json.dumps(predictions.tolist()))