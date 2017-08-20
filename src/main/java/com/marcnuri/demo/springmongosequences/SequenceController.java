/*
 * SequenceController.java
 *
 * Created on 2017-08-19, 8:35
 */
package com.marcnuri.demo.springmongosequences;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2017-08-19.
 */
@RestController
@RequestMapping(path="/sequence")
public class SequenceController {

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
	@RequestMapping(path = "/invoice", method = RequestMethod.GET)
	public ResponseEntity<String> getNextInvoice(){
		return ResponseEntity.ok(sequenceService.getNextInvoiceId());
	}

	@RequestMapping(path = "/shipment", method = RequestMethod.GET)
	public ResponseEntity<String> getNextShipment(){
		return ResponseEntity.ok(sequenceService.getNextShipmentId());
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
