package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.TokensValue;

public interface TokensValueDao {
	boolean addOrUpdateTokensValue(TokensValue tokensValue);
	Set<TokensValue> getTokensValueList();
	TokensValue getTokensValueById(long id);
	boolean deleteTokensValue(long Id);
	TokensValue getLastTokensValue();
	Set<TokensValue> getTokensValueListByTokensType(long ctid);
}
