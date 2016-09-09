package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.TokensType;

public interface TokensTypeServices {
	boolean addOrUpdateTokensType(TokensType tokensType);
	Set<TokensType> getTokensTypeList();
	TokensType getTokensTypeById(long id);
	boolean deleteTokensType(long Id);
	TokensType getLastTokensType();
	TokensType getTokensTypeByHopperType(long hopperTypeID);
}
