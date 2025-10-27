package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TransactionDto;
import com.example.dto.UserDto;
import com.example.service.TransactionService;

@RestController
public class TransactionApi {
	@Autowired
	private TransactionService service;
 @PostMapping("/transfer")
	public UserDto fundTransfer( @RequestBody TransactionDto transactionDto) {
		return service.fundTransfer(transactionDto);
	}
}
