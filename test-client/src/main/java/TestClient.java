import client.RpcClientProxy;

/**
 * Created by fzy at 17:49 on 2020/10/16.
 */
public class TestClient {

    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(10, "这是第一次向服务器申请rpc调用");
        String res = helloService.hello(object);
        System.out.println(res);
    }

}
