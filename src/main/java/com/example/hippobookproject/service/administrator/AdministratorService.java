package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.mapper.administrator.AdiministratorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorService {
    private final AdiministratorMapper adiministratorMapper;
}
