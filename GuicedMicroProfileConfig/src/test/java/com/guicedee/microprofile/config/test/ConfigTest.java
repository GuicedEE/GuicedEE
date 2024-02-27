package com.guicedee.microprofile.config.test;

import lombok.*;
import org.eclipse.microprofile.config.inject.*;

@Getter
@Setter
public class ConfigTest
{
	@ConfigProperty
	private String test;
}
