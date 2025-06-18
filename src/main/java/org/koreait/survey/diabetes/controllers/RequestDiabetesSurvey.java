package org.koreait.survey.diabetes.controllers;

import lombok.Data;
import org.koreait.global.constants.Gender;
import org.koreait.survey.diabetes.constants.SmokingHistory;

@Data
public class RequestDiabetesSurvey {
    private String mode;
    private Gender gender;
    private int age;
    private boolean hypertension; // 고혈압
    private boolean heartDisease; // 심장질환
    private SmokingHistory smokingHistory;
    private double height;
    private double weight;
    private double hbA1c; // 당화혈색소 수치
    private double bloodGlucoseLevel;
}
