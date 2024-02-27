import com.guicedee.guicedinjection.interfaces.*;
import com.guicedee.microprofile.config.*;
import com.guicedee.microprofile.config.implementations.*;

module com.guicedee.microprofile.config {
	
	exports com.guicedee.microprofile.config;
	
	requires transitive io.smallrye.config.core;
	
	requires transitive com.guicedee.guicedinjection;
	requires org.apache.commons.beanutils;
	requires static lombok;
	
	provides com.guicedee.guicedinjection.interfaces.IGuicePreStartup with MicroProfileConfigContext;
	provides IGuiceModule with MicroProfileConfigBinder;
	
	opens com.guicedee.microprofile.config.implementations to com.google.guice;
}