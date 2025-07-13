import pickle
import numpy as np
import pandas as pd
from sklearn.linear_model import SGDClassifier
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split, GridSearchCV


# CSV Read & String -> int
df = pd.read_csv("diabetes_prediction_dataset.csv")

# gender : Female = 0, Male = 1 Other = 2

"""
No Info = 0
current = 1
ever = 2
former = 3
never = 4
not current = 5
"""

import numpy as np

df =df.replace(to_replace={'gender':{'Female':0, 'Male':1, 'Other': 2}})
df =df.replace(to_replace={'smoking_history':{'No Info':0, 'current': 1, 'ever': 2, 'former': 3, 'never': 4, 'not current': 5}})

# train & target set
diabetes_target = df['diabetes'].to_numpy()
diabetes_data = df.drop('diabetes', axis=1).to_numpy()

# train / test 
train_input, test_input, train_target, test_target = train_test_split(
    diabetes_data, diabetes_target, test_size=0.1
)

# data 정규화
ss = StandardScaler()
ss.fit(train_input)

train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)

# SGDClassfierf 가장 좋은 모델 생성 || 가장 좋은 모델 찾기
params = {'max_iter': np.arange(90, 120)}

gs = GridSearchCV(SGDClassifier(loss='log_loss', n_jobs=-1, tol=None), params, n_jobs=-1)
gs.fit(train_scaled, train_target)

model = gs.best_estimator_

# 학습 모델 저장
with open("model.pkl", "wb") as f:
    pickle.dump(model, f)

# 표준 점수(정규화) 저장
with open("scaler.pkl", "wb") as f:
    pickle.dump(ss, f)