package com.guicedee.microprofile.config.implementations;

import com.google.common.base.*;
import com.google.inject.*;
import com.google.inject.matcher.*;
import com.google.inject.spi.*;
import com.guicedee.guicedinjection.*;
import com.guicedee.guicedinjection.interfaces.*;
import com.guicedee.microprofile.config.*;
import io.smallrye.config.*;
import lombok.extern.java.*;
import org.apache.commons.beanutils.*;
import org.eclipse.microprofile.config.ConfigValue;
import org.eclipse.microprofile.config.inject.*;

import java.lang.reflect.*;
import java.util.logging.*;

@Log
public class MicroProfileConfigBinder extends AbstractModule implements IGuiceModule<MicroProfileConfigBinder>
{
	@Override
	protected void configure()
	{
		bind(SmallRyeConfig.class).toProvider(SmallRyeConfigProvider.class);
		bindListener(Matchers.any(), new TypeListener()
		{
			@Override
			public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter)
			{
				encounter.register((InjectionListener<I>) injectee -> {
					if (injectee != null)
					{
						Class<?> aClass = injectee.getClass();
						for (Field field : aClass.getDeclaredFields())
						{
							if (field.isAnnotationPresent(ConfigProperty.class))
							{
								String configProperyName = "";
								if (Strings.isNullOrEmpty(field
										                          .getAnnotation(ConfigProperty.class)
										                          .name()))
								{
									configProperyName = field.getName();
								}
								else
								{
									configProperyName = field
											                    .getAnnotation(ConfigProperty.class)
											                    .name();
								}
								ConfigValue configValue = MicroProfileConfigContext
										                          .getConfig()
										                          .getConfigValue(configProperyName);
								if (configValue != null)
								{
									try
									{
										PropertyUtils.setSimpleProperty(injectee, field.getName(), configValue.getValue());
									}
									catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
									{
										log.warning("Cannot find property setter for [" + field.getName() + "] on [" + aClass.getCanonicalName() + "]. Trying setting using field");
										try
										{
											field.setAccessible(true);
											field.set(injectee, configValue.getValue());
										}
										catch (InaccessibleObjectException | IllegalAccessException | IllegalArgumentException e1)
										{
											log.log(Level.SEVERE, "Could not set config property field inaccessible object for [" + field.getName() + "] on [" + aClass.getCanonicalName() + "]", e1);
										}
									}
								}
							}
						}
					}
				});
			}
		});
		super.configure();
	}
}
