package com.microservice.transaction.client;

import com.microservice.transaction.dto.BorrowDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="BorrowClient", url = "${client.post.borrow}")
public interface BorrowClient {

    @PostMapping("/borrows/many")
    ResponseEntity<List<BorrowDto>> addBorrows(@RequestBody List<BorrowDto> dto);
}
