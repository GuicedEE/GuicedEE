package com.guicedee.microprofile.config.test;

import com.google.common.base.*;
import com.google.inject.*;
import com.guicedee.guicedinjection.*;

import static org.junit.jupiter.api.Assertions.*;

class MicroProfileConfigContextTest
{
	
	@org.junit.jupiter.api.Test
	void getConfig()
	{
		Injector inject = GuiceContext.inject();
		ConfigTest instance = inject.getInstance(ConfigTest.class);
		assertFalse(Strings.isNullOrEmpty(instance.getTest()));
	}
}