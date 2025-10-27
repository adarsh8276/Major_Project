package com.example.service;

import com.example.dto.AddMoneyDto;
import com.example.entity.Wallet;

public interface WalletService {
	Wallet registerNewWallet(int userId);
	Wallet addMoney(AddMoneyDto  addMoneyDto);
}
