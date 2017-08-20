/*
 * SequenceService.java
 *
 * Created on 2017-08-18, 19:54
 */
package com.marcnuri.demo.springmongosequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-08-18.
 *
 * <a href="http://blog.marcnuri.com/">blog.marcnuri.com</a>
 */
@Service
public class SequenceService {

//**************************************************************************************************
//  Fields
//**************************************************************************************************
	public enum Sequences {

		INVOICE("invoice", "INV"),
		SHIPMENT("shipment", "EXP");

		private final String id;
		private final String prefix;

		Sequences(String id, String prefix) {
			this.id = id;
			this.prefix = prefix;
		}

		public String getId() {
			return id;
		}

		public String getPrefix() {
			return prefix;
		}

		public String format(Long value) {
			return String.format("%s%07d", getPrefix(), value);
		}
	}

	@Autowired
	private MongoOperations mongo;

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
	/**
	 * Returns the next formatted value for the {@link Sequences#SHIPMENT} sequence
	 *
	 * @return the next value for {@link Sequences#SHIPMENT}
	 */
	public final String getNextShipmentId(){
		return getNextValue(Sequences.SHIPMENT);
	}

	/**
	 * Returns the next formatted value for the {@link Sequences#INVOICE} sequence
	 *
	 * @return the next value for {@link Sequences#INVOICE}
	 */
	public final String getNextInvoiceId(){
		return getNextValue(Sequences.INVOICE);
	}

	/**
	 * Returns the next formatted value available for the specified {@link Sequences}
	 *
	 * @param sequence for which to retrieve the next sequence value
	 * @return the next value for the {@link Sequences}
	 */
	private String getNextValue(Sequences sequence) {
		return sequence.format(getNextValue(sequence.getId()));
	}

	/**
	 * Returns the next value available for the specified sequenceId
	 *
	 * @param sequenceId for which to retrieve the next sequence value
	 * @return the next value for the {@link Sequence}
	 */
	private Long getNextValue(String sequenceId) {
		//https://docs.mongodb.com/v3.0/tutorial/create-an-auto-incrementing-field/
		final Sequence sequence = mongo.findAndModify(
				query(where("_id").is(sequenceId)),
				new Update().inc("value",1),
				options().returnNew(true).upsert(true),
				Sequence.class);
		return sequence.getValue();
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
