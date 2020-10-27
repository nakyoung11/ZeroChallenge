package com.nakihome.zerochallenge.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.ClientAbortException;
import org.omg.DynamicAny.NameValuePair;

public class KakaoLoginBO {
	private final static String K_CLIENT_ID = "62e7590eb6ec8741e4968b15048450e7";
	private final static String K_CLIENT_SECRET = "m694Ekzt9vRcG3cJg9ZqL2wOE4dJ2LaM";
	private final static String K_REDIRECT_URI = "http://localhost:8090/user/kakaocallback";
	private final static String K_SESSION_STATE = "oauth_state";
	/* 프로필 조회 API URL */
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

	public static String getAuthorizationUrl(HttpSession session) {

	
	}


