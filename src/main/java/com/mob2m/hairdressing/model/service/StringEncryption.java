package com.mob2m.hairdressing.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StringEncryption {
	public String getEncrypt(String transform) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(transform);
	}

}
