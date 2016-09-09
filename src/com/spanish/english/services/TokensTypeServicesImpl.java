package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TokensTypeDao;
import com.spanish.english.form.TokensType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("tokensTypeServices")
public class TokensTypeServicesImpl implements TokensTypeServices {

	@Autowired
	TokensTypeDao tokensTypeDao ;
	
	@Override
	public boolean addOrUpdateTokensType(TokensType tokensType) {
		return tokensTypeDao.addOrUpdateTokensType(tokensType);
	}

	@Override
	public Set<TokensType> getTokensTypeList() {
		return tokensTypeDao.getTokensTypeList();
	}

	@Override
	public TokensType getTokensTypeById(long id) {
		return tokensTypeDao.getTokensTypeById(id);
	}

	@Override
	public boolean deleteTokensType(long Id) {
		return tokensTypeDao.deleteTokensType(Id);
	}

	@Override
	public TokensType getLastTokensType() {
		return tokensTypeDao.getLastTokensType();
	}

	@Override
	public TokensType getTokensTypeByHopperType(long hopperTypeID) {
		return tokensTypeDao.getTokensTypeByHopperType(hopperTypeID);
	}

}
