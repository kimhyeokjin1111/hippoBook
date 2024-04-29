package com.example.hippobookproject.service.book;

import com.example.hippobookproject.mapper.book.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookHasMapper bookHasMapper;
    private final BookCateMapper bookCateMapper;
    private final BookCaseMapper bookCaseMapper;
    private final PublisherMapper publisherMapper;

}
