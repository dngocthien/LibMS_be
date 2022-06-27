//package com.microservice.borrow.services;
//
//import com.microservice.borrow.dto.TransactionDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.time.Duration;
//
//@Service
//public class UserService {
//
//    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
//
//    @Autowired
//    private WebClient localApiClient;
//
//    public TransactionDto getTransactionByUserId(long id) {
//        return localApiClient
//                .get()
//                .uri("/transactions/user/" + id)
//                .retrieve()
//                .bodyToMono(TransactionDto.class)
//                .block(REQUEST_TIMEOUT);
//    }
//
//
//}