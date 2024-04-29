package com.example.hippobookproject.service.alarm;

import com.example.hippobookproject.mapper.alarm.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AlarmService {
    private final AlarmMapper alarmMapper;

}
