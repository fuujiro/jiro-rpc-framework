import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fzy at 14:48 on 2020/10/16.
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("接受到了：" + object.getMessage());
        return "这是调用的返回值：" + object.getId();
    }

}
