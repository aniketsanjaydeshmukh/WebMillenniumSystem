package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.TokensNameValue;

public interface TokensNameValueServices {
	boolean addOrUpdateTokensNameValue(TokensNameValue tokensNameValue);
	Set<TokensNameValue> getTokensNameValueList();
	TokensNameValue getTokensNameValueById(long id);
	boolean deleteTokensNameValue(long Id);
	Set<TokensNameValue> getTokensNameValueByCountry(long cID);
	TokensNameValue getTokensNameValueByCountryAndTokensName(long countryID,long tokensNameID);
}
