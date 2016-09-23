package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.TokensName;

public interface TokensNameDao {
	boolean addOrUpdateTokensName(TokensName tokensName);
	Set<TokensName> getTokensNameList();
	TokensName getTokensNameById(long id);
	boolean deleteTokensName(long Id);
}
