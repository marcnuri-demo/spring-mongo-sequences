/*
 * EnduserService.java
 *
 * Created on 2017-10-04, 7:26
 */
package com.marcnuri.demo.springmongosequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-10-04.
 */
@Service
public class EnduserService {

//**************************************************************************************************
//  Fields
//**************************************************************************************************
	@Autowired
	private MongoOperations mongoOperations;

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
	public Enduser insertUser(String username) {
		final Enduser enduser = mongoOperations.findAndModify(
				query(where("username").is(username)),
				new Update().set("username",username),
				options().returnNew(true).upsert(true),
				Enduser.class);
		return enduser;
	}

	public Enduser login(String username){
		Enduser user = mongoOperations.
				findOne(
						new Query().addCriteria(
								Criteria.where("username")
										.is(username)),Enduser.class);
		return user;
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
