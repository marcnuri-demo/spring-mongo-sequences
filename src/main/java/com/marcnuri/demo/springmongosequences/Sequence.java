/*
 * SequenceRepository.java
 *
 * Created on 2017-08-18, 19:55
 */
package com.marcnuri.demo.springmongosequences;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * {@link Document} to hold information for sequences
 *
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-08-18.
 *
 * <a href="http://blog.marcnuri.com/">blog.marcnuri.com</a>
 */

@Document(collection = "sequences")
public class Sequence {

//**************************************************************************************************
//  Fields
//**************************************************************************************************
	@Id
	private String id;
	private Long value;

//**************************************************************************************************
//  Constructors
//**************************************************************************************************

//**************************************************************************************************
//  Abstract Methods
//**************************************************************************************************

//**************************************************************************************************
//  Overridden Methods
//**************************************************************************************************
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Sequence sequence = (Sequence) o;

		if (id != null ? !id.equals(sequence.id) : sequence.id != null) return false;
		return value != null ? value.equals(sequence.value) : sequence.value == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}


//**************************************************************************************************
//  Other Methods
//**************************************************************************************************

//**************************************************************************************************
//  Getter/Setter Methods
//**************************************************************************************************
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

//**************************************************************************************************
//  Static Methods
//**************************************************************************************************

//**************************************************************************************************
//  Inner Classes
//**************************************************************************************************

}
