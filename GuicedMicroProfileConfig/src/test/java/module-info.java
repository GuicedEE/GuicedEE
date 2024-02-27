module com.guicedee.microprofile.config.test {
	requires com.guicedee.microprofile.config;
	requires org.junit.jupiter.api;
	requires static lombok;
	
	exports com.guicedee.microprofile.config.test to com.google.guice,org.apache.commons.beanutils;
	opens com.guicedee.microprofile.config.test to org.junit.platform.commons;
	
}