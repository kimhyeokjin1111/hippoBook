package com.example.hippobookproject.mapper.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
    public interface AlarmMapper {
    List<AlarmDto> selectAlarm();
    List<AlarmDto> findByID(Long userId);
    void insertAlarm(AlarmDto alarmDto);
    void updateAlarmCheckByUserId(Long userId);

    Boolean hasUncheckedAlarms(Long userId);

    }
