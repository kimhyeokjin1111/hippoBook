package com.example.hippobookproject.dto.alarm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlarmDto {
    private String alarmContent;
    private String alarmDate;
    private String userNickName;


//    ALARM_ID, ALARM_CONTENT, ALARM_DATE, ALARM_TO, ALARM_FROM
}
