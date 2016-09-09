package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.TokensValue;

public interface TokensValueServices {
	boolean addOrUpdateTokensValue(TokensValue tokensValue);
	Set<TokensValue> getTokensValueList();
	TokensValue getTokensValueById(long id);
	boolean deleteTokensValue(long Id);
	TokensValue getLastTokensValue();
	Set<TokensValue> getTokensValueListByTokensType(long ctid);
}
