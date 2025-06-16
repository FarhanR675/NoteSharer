package com.Farhan675.NoteSharer.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "";
    private final long EXPIRATION_TIME = 86400000; // this is 24 hours in milliseconds

}
