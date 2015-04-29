package org.mobicents.slee.resource.amqp;

import java.util.Random;
import java.io.Serializable;

import org.springframework.amqp.core.Message;

/**
 * <p>
 * The AMQP protocol is based on sending and receiving {@link Message} to/from
 * an AMQP Server.
 * </p>
 * <p>
 * We have defined one Event for the AMQPRA called {@link AMQPEvent}
 * </p>
 * @author akrem benmarzouk
 * @author helmi benabdallah
 *
 */

public class AMQPEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7463843722051654398L;
	
	private final long id;
	
	private final Message amqpMessage;
	
	
	public AMQPEvent() {
		id = new Random().nextLong() ^ System.currentTimeMillis();
		this.amqpMessage = null;
	}
	
	public AMQPEvent(Message amqpMessage) {
		id = new Random().nextLong() ^ System.currentTimeMillis();
		this.amqpMessage = amqpMessage;
	}
	
	
	/**
    * The Message included in the AmqpEvent.
    * 
    * @return Message containing data sent through this event
    */
	public Message getAmqpMessage(){
		return amqpMessage;
	}


	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		return (o instanceof AMQPEvent) && ((AMQPEvent)o).id == id;
	}
	
	public int hashCode() {
		return (int) id;
	}
	
	public String toString() {
		return "AMQPEvent[" + hashCode() + "]";
	}

}
