package com.example.hippobookproject.service.declaration;

import com.example.hippobookproject.mapper.declaration.DeclarationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeclarationService {
    private final DeclarationMapper declarationMapper;
}
