package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.TokensName;

public interface TokensNameServices {
	boolean addOrUpdateTokensName(TokensName tokensName);
	Set<TokensName> getTokensNameList();
	TokensName getTokensNameById(long id);
	boolean deleteTokensName(long Id);
}
