package org.mobicents.slee.resource.amqp;

import java.util.Properties;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.core.ReplyToAddressCallback;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class AMQPWrapper implements AMQPActivity{
	
	private final AMQPResourceAdaptor ra;
	private AmqpTemplate amqpTemplate;
	private AmqpAdmin amqpAdmin;
	private final ConsumerID id;

	public AMQPWrapper(ConsumerID id, AMQPResourceAdaptor ra,
			String amqpHost, String amqpQueueName) {
		
		
		this.id = id;
		this.ra = ra;
		if(ra!=null)
			ra.connectionOpened(this);
		
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(amqpHost);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setConnectionCacheSize(25);
		amqpAdmin =new RabbitAdmin(connectionFactory);
		amqpTemplate = new RabbitTemplate(connectionFactory);
		//The routing key is set to the name of the queue by the broker for the default exchange.
		((RabbitTemplate) amqpTemplate).setRoutingKey(amqpQueueName);
		//Where we will synchronously receive messages from
		((RabbitTemplate) amqpTemplate).setQueue(amqpQueueName);
	}

	
	public ConsumerID getConsumerID() {
	return id;
}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void convertAndSend(Object arg0) throws AmqpException {
		amqpTemplate.convertAndSend(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void convertAndSend(String arg0, Object arg1) throws AmqpException {
		amqpTemplate.convertAndSend(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void convertAndSend(Object arg0, MessagePostProcessor arg1)
			throws AmqpException {
		amqpTemplate.convertAndSend(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void convertAndSend(String arg0, String arg1, Object arg2)
			throws AmqpException {
		amqpTemplate.convertAndSend(arg0, arg1, arg2);
	}

	@Override
	public void convertAndSend(String arg0, Object arg1,
			MessagePostProcessor arg2) throws AmqpException {
		amqpTemplate.convertAndSend(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void convertAndSend(String arg0, String arg1, Object arg2,
			MessagePostProcessor arg3) throws AmqpException {
		amqpTemplate.convertAndSend(arg0, arg1, arg2, arg3);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object convertSendAndReceive(Object arg0) throws AmqpException {
		return amqpTemplate.convertSendAndReceive(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object convertSendAndReceive(String arg0, Object arg1)
			throws AmqpException {
		return amqpTemplate.convertSendAndReceive(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object convertSendAndReceive(Object arg0, MessagePostProcessor arg1)
			throws AmqpException {
		return amqpTemplate.convertSendAndReceive(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object convertSendAndReceive(String arg0, String arg1, Object arg2)
			throws AmqpException {
		return amqpTemplate.convertSendAndReceive(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object convertSendAndReceive(String arg0, Object arg1,
			MessagePostProcessor arg2) throws AmqpException {
		return amqpTemplate.convertSendAndReceive(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object convertSendAndReceive(String arg0, String arg1, Object arg2,
			MessagePostProcessor arg3) throws AmqpException {
		return amqpTemplate.convertSendAndReceive(arg0, arg1, arg2, arg3);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Message receive() throws AmqpException {
		return amqpTemplate.receive();
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Message receive(String arg0) throws AmqpException {
		return amqpTemplate.receive(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object receiveAndConvert() throws AmqpException {
		return amqpTemplate.receiveAndConvert();
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Object receiveAndConvert(String arg0) throws AmqpException {
		return amqpTemplate.receiveAndConvert(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public <R, S> boolean receiveAndReply(ReceiveAndReplyCallback<R, S> arg0)
			throws AmqpException {
		return amqpTemplate.receiveAndReply(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public <R, S> boolean receiveAndReply(String arg0,
			ReceiveAndReplyCallback<R, S> arg1) throws AmqpException {
		return amqpTemplate.receiveAndReply(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public <R, S> boolean receiveAndReply(ReceiveAndReplyCallback<R, S> arg0,
			ReplyToAddressCallback<S> arg1) throws AmqpException {
		return amqpTemplate.receiveAndReply(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public <R, S> boolean receiveAndReply(ReceiveAndReplyCallback<R, S> arg0,
			String arg1, String arg2) throws AmqpException {
		return amqpTemplate.receiveAndReply(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public <R, S> boolean receiveAndReply(String arg0,
			ReceiveAndReplyCallback<R, S> arg1, ReplyToAddressCallback<S> arg2)
			throws AmqpException {
		return amqpTemplate.receiveAndReply(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public <R, S> boolean receiveAndReply(String arg0,
			ReceiveAndReplyCallback<R, S> arg1, String arg2, String arg3)
			throws AmqpException {
		return amqpTemplate.receiveAndReply(arg0, arg1, arg2, arg3);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void send(Message arg0) throws AmqpException {
		amqpTemplate.send(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void send(String arg0, Message arg1) throws AmqpException {
		amqpTemplate.send(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void send(String arg0, String arg1, Message arg2)
			throws AmqpException {
		amqpTemplate.send(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Message sendAndReceive(Message arg0) throws AmqpException {
		return amqpTemplate.sendAndReceive(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Message sendAndReceive(String arg0, Message arg1)
			throws AmqpException {
		return amqpTemplate.sendAndReceive(arg0, arg1);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Message sendAndReceive(String arg0, String arg1, Message arg2)
			throws AmqpException {
		return amqpTemplate.sendAndReceive(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void declareBinding(Binding arg0) {
		amqpAdmin.declareBinding(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void declareExchange(Exchange arg0) {
		amqpAdmin.declareExchange(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Queue declareQueue() {
		return amqpAdmin.declareQueue();
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public String declareQueue(Queue arg0) {
		return amqpAdmin.declareQueue(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public boolean deleteExchange(String arg0) {
		return amqpAdmin.deleteExchange(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public boolean deleteQueue(String arg0) {
		return amqpAdmin.deleteQueue(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void deleteQueue(String arg0, boolean arg1, boolean arg2) {
		amqpAdmin.deleteQueue(arg0, arg1, arg2);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public Properties getQueueProperties(String arg0) {
		return amqpAdmin.getQueueProperties(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void purgeQueue(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		amqpAdmin.purgeQueue(arg0, arg1);

	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void removeBinding(Binding arg0) {
		amqpAdmin.removeBinding(arg0);
	}

	/**
	 *
	 *{@inheritDoc}
	 *
	 */
	@Override
	public void endActivity() {
		ra.connectionClosed(this.id);
	}


}
