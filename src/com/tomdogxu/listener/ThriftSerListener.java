package com.tomdogxu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.tomdogxu.thrift.server.Hello;
import com.tomdogxu.thrift.server.Server;

/**
 * Application Lifecycle Listener implementation class ThriftSerListener
 *
 */
@WebListener
public class ThriftSerListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ThriftSerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("content initialized");
        Runnable runnable = new Runnable() {
        public void run() {
        	TNonblockingServerTransport serverTransport = null;
    		try {
    			serverTransport = new TNonblockingServerSocket(19090);
    		} catch (TTransportException e) {
    			e.printStackTrace();
    		}

    		//Server 为Hello接口的实现类
    		Hello.Processor<Hello.Iface> processor = new Hello.Processor<Hello.Iface>(
    				new Server());
    		Factory protFactory = new TBinaryProtocol.Factory(true, true);
    		TNonblockingServer.Args args = new TNonblockingServer.Args(
    				serverTransport);
    		args.processor(processor);
    		args.protocolFactory(protFactory);
    		TServer server = new TNonblockingServer(args);
    		System.out.println("Start server on port 19090 ...");
    		server.serve();
        }
        };
        //启动这个线程
        new Thread(runnable).start();
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
