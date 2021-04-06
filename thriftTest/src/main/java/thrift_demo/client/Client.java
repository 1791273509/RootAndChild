package thrift_demo.client;


import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift_demo.UserService;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/3/26 下午4:14
 */

@Slf4j
public class Client {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 2345;//Thrift server listening port
    private static final int TIMEOUT = 3000;

    private void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            UserService.Client client = new UserService.Client(protocol);
            transport.open();
            System.out.println(client.getName(1));
            System.out.println(client.isExist("haha"));
            log.info("ddd");
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        log.info("Client start");
        Client client = new Client();
        client.startClient("Tom");
        log.info("Client end");
    }

}

