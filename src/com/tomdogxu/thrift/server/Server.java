package com.tomdogxu.thrift.server;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;


/**
 * Thrift²âÊÔ·þÎñÆ÷
 */
public class Server implements Hello.Iface {
	@Override
	public String helloString(String para) throws TException {
		return "hello";
	}
}
