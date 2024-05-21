package com.example.hippobookproject.mapper.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
    public interface AlarmMapper {
    List<AlarmDto> selectAlarm();
    List<AlarmDto> findByID(Long userId);
    void insertAlarm(AlarmDto alarmDto);

    }
