package com.microservice.borrow.feign;

import com.microservice.borrow.dto.ByTime;
import com.microservice.borrow.dto.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TransactionClient", url = "${client.post.baseUrl}")
public interface TransactionClient {
    @GetMapping("/transactions")
    List<TransactionDto> findAllTransaction();

    @GetMapping("/transactions/overdue")
    List<TransactionDto> findOverdueTransaction();

    @GetMapping("/transactions/{id}")
    TransactionDto findTransactionById(@PathVariable("id") Integer id);

    @GetMapping("/transactions/user/{id}")
    List<TransactionDto> findTransactionByUserId(@PathVariable("id") Integer id);

    @PostMapping("/transactions/time")
    public List<TransactionDto> findTransactionByTime(@RequestBody ByTime byTime);

    @PostMapping("/transactions")
    TransactionDto addTransaction(TransactionDto dto);

    @PutMapping("/transactions/{id}")
    TransactionDto updateBook(@PathVariable Integer id, @RequestBody TransactionDto dto);
}