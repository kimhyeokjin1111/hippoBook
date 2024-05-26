package com.example.hippobookproject.service.book;

import com.example.hippobookproject.dto.book.AladinApiDto;
import com.example.hippobookproject.mapper.book.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    //@Value("${api.key.aladin}")
    private String apiKey;

    public AladinApiDto findAllBook(){
        String baseUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx";
        String queryType = "Bestseller";
        String searchTarget = "Book";
        String output = "js";
        String version = "20131101";
        int start = 1;
        int maxResults = 50;

        String url = baseUrl + "?ttbkey=" + apiKey +
                "&QueryType=" + queryType +
                "&SearchTarget=" + searchTarget +
                "&output=" + output +
                "&version=" + version +
                "&Start=" + start +
                "&MaxResults=" + maxResults;
        log.info("url : {}", url);


        WebClient webClient = WebClient.builder().build();
        AladinApiDto result = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(AladinApiDto.class)
                .block();

        System.out.println("result = " + result);
        return result;
    }

}
