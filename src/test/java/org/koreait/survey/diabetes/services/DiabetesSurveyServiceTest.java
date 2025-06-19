package org.koreait.survey.diabetes.services;

import org.junit.jupiter.api.Test;
import org.koreait.global.constants.Gender;
import org.koreait.survey.diabetes.constants.SmokingHistory;
import org.koreait.survey.diabetes.controllers.RequestDiabetesSurvey;
import org.koreait.survey.diabetes.entities.DiabetesSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiabetesSurveyServiceTest {

    @Autowired
    private DiavetesSurveyService surveyService;

    @Test
    void test(){
        RequestDiabetesSurvey survey = new RequestDiabetesSurvey();
        survey.setGender(Gender.MALE);
        survey.setAge(41);
        survey.setHypertension(false);
        survey.setHeartDisease(false);
        survey.setSmokingHistory(SmokingHistory.EVER);
        survey.setHeight(178.5);
        survey.setWeight(120);
        survey.setHbA1c(8.2);
        survey.setBloodGlucoseLevel(126.0);

        DiabetesSurvey item = surveyService.process(survey);
        System.out.println(item);
    }
}
