package test;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;
import com.tomdogxu.thrift.server.Hello;
/**
 * Thrift测试客户端
 */
public class Client {
	@Test
	public void testThrift() {
		long startTime = System.currentTimeMillis();
		try {
			TTransport transport = new TFramedTransport(new TSocket(
					"localhost", 19090));
			TBinaryProtocol protocol = new TBinaryProtocol(transport);
			// TCompactProtocol protocol = new TCompactProtocol(transport);
			Hello.Client client = new Hello.Client(protocol);
			transport.open();
			for (int i = 0; i < 1000; i++) {
				System.out.println(client.helloString("login"));
			}
			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(" 本次调用完成时间:" + (endTime - startTime));
	}
}
