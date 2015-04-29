package org.mobicents.slee.resource.amqp;


import javax.slee.ActivityContextInterface;
import javax.slee.FactoryException;
import javax.slee.UnrecognizedActivityException;
import javax.slee.resource.ResourceAdaptorTypeID;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * 
 * @author akrem benmarzouk
 * @author helmi benabdallah
 * 
 */

public interface AMQPActivityContextInterfaceFactory {
	
	public static final ResourceAdaptorTypeID RESOURCE_ADAPTOR_TYPE_ID = new ResourceAdaptorTypeID(
            "AMQPResourceAdaptorType", "org.mobicents", "1.0");

	public ActivityContextInterface getActivityContextInterface(AmqpTemplate amqpTemplate)
			throws NullPointerException, UnrecognizedActivityException,
			FactoryException;

}
