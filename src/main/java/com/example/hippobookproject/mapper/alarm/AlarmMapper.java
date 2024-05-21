package com.example.hippobookproject.mapper.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {
    List<AlarmDto> selectAlarm();

    void selectById (Long userId);
    void insertAlarm(AlarmDto alarmDto);

}
