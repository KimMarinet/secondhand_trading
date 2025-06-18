package org.koreait.survey.diabetes.constants;

public enum SmokingHistory {
    NO_INFO(0),
    CURRENT(1),
    EVER(2),
    FORMER(3),
    NEVER(4),
    NOT_CURRENT(5);

    private final int num;

    SmokingHistory(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }
}
