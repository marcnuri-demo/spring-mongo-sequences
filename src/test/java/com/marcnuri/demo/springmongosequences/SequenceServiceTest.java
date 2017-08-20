/*
 * SequenceServiceTest.java
 *
 * Created on 2017-08-18, 19:39
 */
package com.marcnuri.demo.springmongosequences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Pattern;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-08-18.
 *
 * <a href="http://blog.marcnuri.com/">blog.marcnuri.com</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	classes= {
		MongoConfiguration.class
	})
public class SequenceServiceTest {

//**************************************************************************************************
//  Fields
//**************************************************************************************************
	@Autowired
	private SequenceService sequenceService;

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
	@Test
	public void getNextShipmentId_OK() {
		testSequence(Pattern.compile("EXP[0-9]{7}"), () -> sequenceService.getNextShipmentId());
	}
	@Test
	public void getNextInvoiceId_OK() {
		testSequence(Pattern.compile("INV[0-9]{7}"), () -> sequenceService.getNextInvoiceId());
	}

	/**
	 * Common testing method for every sequence
	 *
	 * @param sequencePattern
	 * @param predicate
	 */
	private void testSequence(Pattern sequencePattern, TestSequencePredicate predicate){
		for(int it = 1; it <= 100; it++){
			// Retrieve sequence value
			String seqValue = predicate.getNextSequenceValue();
			assertNotNull(seqValue);
			assertTrue(sequencePattern.matcher(seqValue).matches());
			assertTrue(seqValue.endsWith(String.valueOf(it)));
		}
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
	/**
	 * Interface to allow to pass a lambda expression to the common testing method
	 * {@link SequenceServiceTest#testSequence(Pattern, TestSequencePredicate)}
	 *
	 */
	private interface TestSequencePredicate {
		String getNextSequenceValue();
	}

}
