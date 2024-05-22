package com.example.hippobookproject.service.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.mapper.alarm.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmMapper alarmMapper;

    public List<AlarmDto> selectAlarm() {
        return alarmMapper.selectAlarm();
    }

    public List<AlarmDto> findById(Long userId) {
        return alarmMapper.findByID(userId);
    }

    public void insertAlarm(AlarmDto alarmDto) {
        alarmMapper.insertAlarm(alarmDto);
    }

    public void updateAlarmCheckByUserId(Long userId) {
        alarmMapper.updateAlarmCheckByUserId(userId);
    }

    public boolean hasUncheckedAlarms(Long userId) {
        return alarmMapper.hasUncheckedAlarms(userId);
    }



}
