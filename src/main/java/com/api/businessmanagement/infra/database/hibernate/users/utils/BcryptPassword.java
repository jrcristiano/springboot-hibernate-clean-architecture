package com.api.businessmanagement.infra.database.hibernate.users.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPassword {
	public static String encode(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
}
