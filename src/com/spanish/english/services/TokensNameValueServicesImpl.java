package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TokensNameValueDao;
import com.spanish.english.form.TokensNameValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("tokensNameValueServices")
public class TokensNameValueServicesImpl implements TokensNameValueServices {
	
	@Autowired
	TokensNameValueDao tokensNameValueDao;

	@Override
	public boolean addOrUpdateTokensNameValue(TokensNameValue tokensNameValue) {
		return tokensNameValueDao.addOrUpdateTokensNameValue(tokensNameValue);
	}

	@Override
	public Set<TokensNameValue> getTokensNameValueList() {
		return tokensNameValueDao.getTokensNameValueList();
	}

	@Override
	public TokensNameValue getTokensNameValueById(long id) {
		return tokensNameValueDao.getTokensNameValueById(id);
	}

	@Override
	public boolean deleteTokensNameValue(long Id) {
		return tokensNameValueDao.deleteTokensNameValue(Id);
	}

	@Override
	public Set<TokensNameValue> getTokensNameValueByCountry(long cID) {
		return tokensNameValueDao.getTokensNameValueByCountry(cID);
	}

	@Override
	public TokensNameValue getTokensNameValueByCountryAndTokensName(
			long countryID, long tokensNameID) {
		return tokensNameValueDao.getTokensNameValueByCountryAndTokensName(countryID, tokensNameID);
	}

}
