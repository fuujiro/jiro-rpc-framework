import registry.DefaultServiceRegistry;
import registry.ServiceRegistry;
import server.RpcServer;

/**
 * Created by fzy at 17:48 on 2020/10/16.
 */

/*
   某个对象 A 实现了接口 X 和 Y，那么将 A 注册进去后，会有两个服务名 X 和 Y 对应于 A 对象。
   如果出现【某个接口只能有一个对象提供服务】这种情况，按照register的顺序，最新的注册是刷新有效的。
 */

public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService testService = new TestServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(testService);
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }
}
