/*
 * AbstractMongoConfiguration.java
 *
 * Created on 2017-08-18, 19:27
 */
package com.marcnuri.demo.springmongosequences;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-08-18.
 *
 * <a href="http://blog.marcnuri.com/">blog.marcnuri.com</a>
 */
@Configuration
@EnableAutoConfiguration(exclude = { EmbeddedMongoAutoConfiguration.class })
@EnableMongoRepositories(
	basePackageClasses = {
		SpringmongosequencesApplication.class
})
@ComponentScan(
	basePackageClasses = {
		SpringmongosequencesApplication.class
})
public class MongoConfiguration{

//**************************************************************************************************
//  Fields
//**************************************************************************************************

//**************************************************************************************************
//  Constructors
//**************************************************************************************************

//**************************************************************************************************
//  Abstract Methods
//**************************************************************************************************

//**************************************************************************************************
//  Overridden Methods
//**************************************************************************************************

//**************************************************************************************************
//  Other Methods
//**************************************************************************************************

//**************************************************************************************************
//  Getter/Setter Methods
//**************************************************************************************************

//**************************************************************************************************
//  Static Methods
//**************************************************************************************************

//**************************************************************************************************
//  Inner Classes
//**************************************************************************************************

}
