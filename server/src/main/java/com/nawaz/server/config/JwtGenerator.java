package com.nawaz.server.config;

import java.util.Map;

import com.nawaz.server.models.User;

public interface JwtGenerator {
	Map<String, String> generateToken(User user);
}
