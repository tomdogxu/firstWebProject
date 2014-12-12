package com.tomdogxu.thrift.server;

import org.apache.thrift.TException;


/**
 * Thrift²âÊÔ·şÎñÆ÷
 */
public class Server implements Hello.Iface {
	@Override
	public String helloString(String para) throws TException {
		return "hello";
	}
}
