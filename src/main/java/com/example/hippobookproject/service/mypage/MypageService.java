package com.example.hippobookproject.service.mypage;

import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.mapper.user.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MypageService {
   private final MypageMapper mypageMapper;

   public IntProfileDto findProfile(Long userId ){
       return mypageMapper.selectProfile(userId)
               .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 번호"));

   }
}
