import registry.DefaultServiceRegistry;
import registry.ServiceRegistry;
import server.RpcServer;

/**
 * Created by fzy at 17:48 on 2020/10/16.
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }
}
