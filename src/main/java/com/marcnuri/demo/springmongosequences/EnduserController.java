/*
 * EnduserController.java
 *
 * Created on 2017-10-04, 7:28
 */
package com.marcnuri.demo.springmongosequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-10-04.
 */
@RestController
@RequestMapping(path="/enduser")
public class EnduserController {

//**************************************************************************************************
//  Fields
//**************************************************************************************************
	@Autowired
	private EnduserService enduserService;

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
	@RequestMapping(value = "/adduser/{username}",method= RequestMethod.GET)
	public Enduser insertUser(@PathVariable String username){
		return enduserService.insertUser(username);
	}

	@RequestMapping(value = "/signin/{username}",method= RequestMethod.GET)
	public Enduser login(@PathVariable String username){
		return enduserService.login(username);
	}

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
