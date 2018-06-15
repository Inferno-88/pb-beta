package com.octopus.pb.security;


public class SecurityConstants {

    public static final String SECRET = "OctopusPaintballAppSignature88";
    public static final long EXPIRATION_TIME = 604_800_000; // 7 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";

}
