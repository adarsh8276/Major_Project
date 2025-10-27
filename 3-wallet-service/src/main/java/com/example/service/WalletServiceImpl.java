package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.dto.AddMoneyDto;
import com.example.dto.UserDto;
import com.example.entity.Wallet;
import com.example.entity.WalletStatus;
import com.example.repo.WalletRepository;
public class WalletServiceImpl implements WalletService {
	@Autowired
	private WalletRepository walletRepo;
	public Wallet registerNewWallet(int userId) {
		boolean userChk=verifyUser(userId);
		if(userChk==true) {
			Wallet w=new Wallet();
			w.setStatus(WalletStatus.ACTIVE);
			w.setUserId(userId);
			w.setWalletBalance(500);
			walletRepo.save(w);
			return w;
		}
	throw new RuntimeException("user already exits");
	}
	@Override
	public Wallet addMoney(AddMoneyDto addMoneyDto) {
		return null;
	}
	boolean verifyUser(int userId) {
		RestTemplate template=new RestTemplate();
		//currently no load balancing is used ////
		String url="http://localhost:9000/users/"+userId;
		UserDto user=template.getForObject(url, UserDto.class);
		if(user!=null) {
			return true;
		}
		else return false;
	}

}
