package com.guicedee.microprofile.config;

import com.guicedee.guicedinjection.interfaces.*;
import io.smallrye.config.*;
import jakarta.inject.*;
import lombok.*;
import lombok.extern.java.*;

@Singleton
@Log
@Getter
public class MicroProfileConfigContext implements IGuicePreStartup<MicroProfileConfigContext>
{
	@Getter
	private static SmallRyeConfig config;
	
	@Override
	public void onStartup()
	{
		SmallRyeConfigBuilder configBuilder = new SmallRyeConfigBuilder()
				                                      .addDefaultSources()
				                                      .addDefaultInterceptors()
				                                      .addDiscoveredSources()
				                                      .addDiscoveredConverters()
				                                      .addDiscoveredInterceptors();
		config = configBuilder.build();
	}
}
