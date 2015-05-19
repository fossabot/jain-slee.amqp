package org.mobicents.slee.resource.amqp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import javax.slee.resource.ActivityHandle;

public class AMQPID implements ActivityHandle {
	private final int seq;

	/**
	 * Construct ID from an input stream, for unmarshalling.
	 * 
	 * @param in
	 * @throws IOException
	 */
	AMQPID(DataInput in) throws IOException {
		this.seq = in.readInt();
	}

	 /**
     * Construct ID from sequence number
     * @param seq
     */
	public AMQPID(int seq) {
		
		this.seq = seq;
	}

	/**
	 * Write ID to an output stream, for marshalling.
	 * 
	 * @param out
	 * @throws IOException
	 */
	void toStream(DataOutput out) throws IOException {
		out.writeInt(seq);
	}

	/**
	 * Used by {@link TelnetMarshaler}.
	 * 
	 * @return the estimated size of a ChannelID when marshalled.
	 */
	static int getEstimatedHandleSize() {
		return 8;
	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return 8 ^ seq;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (o instanceof AMQPID) {
			AMQPID id = (AMQPID) o;
			return (seq == id.seq);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "ChannelID[:" + seq + "]";
	}

}
