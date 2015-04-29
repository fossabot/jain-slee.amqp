package org.mobicents.slee.resource.amqp;


import javax.slee.facilities.Tracer;
import javax.slee.resource.StartActivityException;




/**
 * 
 * Implementation class for AMQPResourceAdaptorSbbInterface
 * 
 * @author akrem benmarzouk
 * 
 */

public class AMQPResourceAdaptorSbbInterfaceImpl  implements AMQPResourceAdaptorSbbInterface {
	
	private final Tracer tracer;
	private final AMQPResourceAdaptor ra;
	
	public AMQPResourceAdaptorSbbInterfaceImpl(AMQPResourceAdaptor ra) {
        this.ra = ra;
        this.tracer = ra.getTracer(AMQPResourceAdaptorSbbInterfaceImpl.class.getName());
	}
	

	@Override
	public AMQPActivity createAMQPActivity() throws StartActivityException {
		if (tracer.isFinestEnabled()) {
            tracer.finest("createAMQPActivity...");
    }
    
    //TODO : finish the AMQPResourceAdaptorSbbInterfaceImpl
    
    return null;
	}
	
	
}
