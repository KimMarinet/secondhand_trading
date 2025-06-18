package org.koreait.survey.diabetes.services;

import lombok.RequiredArgsConstructor;
import org.koreait.survey.diabetes.controllers.RequestDiabetesSurvey;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class DiavetesSurveyService {

    public void process(RequestDiabetesSurvey form){

    }
}
