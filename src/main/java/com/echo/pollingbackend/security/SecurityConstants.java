package com.echo.pollingbackend.security;

public class SecurityConstants {

    public static final String SIGN_UP_URLS = "/api/user/**";
    public static final String HOME_URLS = "/api/home/**";
    public static final String H2_URL = "h2-console/**";
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 2*60*60*1000; // hours*minutes*seconds*milliseconds

}
