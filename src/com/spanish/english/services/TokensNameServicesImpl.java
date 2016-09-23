package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TokensNameDao;
import com.spanish.english.form.TokensName;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("tokensNameServices")
public class TokensNameServicesImpl implements TokensNameServices{

	@Autowired
	TokensNameDao tokensNameDao;
	
	@Override
	public boolean addOrUpdateTokensName(TokensName tokensName) {
		return tokensNameDao.addOrUpdateTokensName(tokensName);
	}

	@Override
	public Set<TokensName> getTokensNameList() {
		return tokensNameDao.getTokensNameList();
	}

	@Override
	public TokensName getTokensNameById(long id) {
		return tokensNameDao.getTokensNameById(id);
	}

	@Override
	public boolean deleteTokensName(long Id) {
		return tokensNameDao.deleteTokensName(Id);
	}

}
