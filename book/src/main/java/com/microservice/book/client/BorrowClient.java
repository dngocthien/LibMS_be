package com.microservice.book.client;

import com.microservice.book.dto.ByTime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "BorrowClient", url = "${client.post.borrow}")
public interface BorrowClient {

    @PostMapping("/borrows/time")
    Map<Integer, Integer> getBookIdsByTime(@RequestBody ByTime byTime);
}
