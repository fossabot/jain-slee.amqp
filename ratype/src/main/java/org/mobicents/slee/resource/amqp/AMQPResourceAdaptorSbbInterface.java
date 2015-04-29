package org.mobicents.slee.resource.amqp;

import javax.slee.resource.ResourceAdaptorTypeID;
import javax.slee.resource.StartActivityException;


/**
 * Provides SBB with the interface to interact with AMQP Resource Adaptor. AMQPResourceAdaptorSbbInterface 
 * is wrapper over {@link org.springframework.amqp.core.AmqpTemplate} and 
 * {@link org.springframework.amqp.core.AmqpAdmin}, it exposes most commonly used methods of AMQP.
 * 
 * @author akrem benmarzouk
 * 
 */
public interface AMQPResourceAdaptorSbbInterface {
	
	public static final ResourceAdaptorTypeID RESOURCE_ADAPTOR_TYPE_ID = AMQPActivityContextInterfaceFactory.RESOURCE_ADAPTOR_TYPE_ID;
	
	/**
     * <p>
     * Creates instance of {@link AMQPActivity} for service that wants either to 
     * manage the AMQP connection or send/receive messages through AMQP.
     * </p>
     * 
     * @return
     * @throws StartActivityException
     */
	public AMQPActivity createAMQPActivity() throws StartActivityException;

}
