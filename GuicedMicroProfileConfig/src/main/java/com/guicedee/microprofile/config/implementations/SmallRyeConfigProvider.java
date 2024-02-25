package com.guicedee.microprofile.config.implementations;

import com.guicedee.microprofile.config.*;
import io.smallrye.config.*;

public class SmallRyeConfigProvider implements com.google.inject.Provider<SmallRyeConfig>
{
	@Override
	public SmallRyeConfig get()
	{
		return MicroProfileConfigContext.getConfig();
	}
	
}
