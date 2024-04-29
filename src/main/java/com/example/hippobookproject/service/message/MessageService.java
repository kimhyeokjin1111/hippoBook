package com.example.hippobookproject.service.message;

import com.example.hippobookproject.mapper.message.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
}
