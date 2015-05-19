package org.mobicents.slee.resource.amqp;


import javax.slee.ActivityContextInterface;
import javax.slee.FactoryException;
import javax.slee.UnrecognizedActivityException;

/**
 * 
 * @author akrem benmarzouk
 * @author helmi benabdallah
 * 
 */

public interface AMQPActivityContextInterfaceFactory {

	public ActivityContextInterface getActivityContextInterface(AMQPActivity amqpActivity)
			throws NullPointerException, UnrecognizedActivityException,
			FactoryException;

}
