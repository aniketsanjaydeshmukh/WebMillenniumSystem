package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TokensValueDao;
import com.spanish.english.form.TokensValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("tokensValueServices")
public class TokensValueServicesImpl implements TokensValueServices{
	
	@Autowired
	TokensValueDao tokensValueDao;

	@Override
	public boolean addOrUpdateTokensValue(TokensValue tokensValue) {
		return tokensValueDao.addOrUpdateTokensValue(tokensValue);
	}

	@Override
	public Set<TokensValue> getTokensValueList() {
		return tokensValueDao.getTokensValueList();
	}

	@Override
	public TokensValue getTokensValueById(long id) {
		return tokensValueDao.getTokensValueById(id);
	}

	@Override
	public boolean deleteTokensValue(long Id) {
		return tokensValueDao.deleteTokensValue(Id);
	}

	@Override
	public TokensValue getLastTokensValue() {
		return tokensValueDao.getLastTokensValue();
	}

	@Override
	public Set<TokensValue> getTokensValueListByTokensType(long ttid) {
		return tokensValueDao.getTokensValueListByTokensType(ttid);
	}

}
