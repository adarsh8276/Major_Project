package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.dto.TransactionDto;
import com.example.dto.UserDto;

@Service
public class TransactionService {
	
	private Logger log=LoggerFactory.getLogger(TransactionService.class);
	@Autowired
	private RestTemplate restTemplate;
	public UserDto fundTransfer(  TransactionDto transactionDto) {
		log.info("fund tranfering from {} and to {}",transactionDto.getFromUserId(),transactionDto.getToUserId());
		String url="http://user-service/users/"+transactionDto.getFromUserId();
		//call to user service
	UserDto userDto=	restTemplate.getForObject(url, UserDto.class);
		return userDto;
	}
}
