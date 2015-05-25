package org.mobicents.slee.resource.amqp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.SerializerMessageConverter;

public class AMQPEventImpl implements AMQPEvent, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6962304839868584949L;
	private final String messageReceived;
	
	public AMQPEventImpl(String messageReceived) {
		super();
		this.messageReceived = messageReceived;
	}
	
//	public AMQPEventImpl(DataInput in) throws IOException {
//		ObjectInputStream ois =new ObjectInputStream((InputStream) in );
//		SerializerMessageConverter converter = new SerializerMessageConverter();
//				Object o = null;
//		try {
//			o =  ois.readObject();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		messageReceived = converter.toMessage(o, new MessageProperties());
//	}

	@Override
	public String getAmqpMessage() {
		return messageReceived;
	}

//	public static int getEstimatedEventSize() {
//		// TODO Auto-generated method stub
//		return 8;
//	}

//	public void toStream(DataOutput out) throws MessageConversionException, IOException {
//		// TODO Auto-generated method stub
//		ObjectOutputStream oos =new ObjectOutputStream( (OutputStream) out );
//		SerializerMessageConverter converter = new SerializerMessageConverter();
//		oos.writeObject(
//				converter.fromMessage(messageReceived)
//						
//				);
//	}

}
