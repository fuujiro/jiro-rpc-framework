import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fzy at 23:23 on 2020/10/18.
 */
public class TestServiceImpl implements HelloService, TestService{

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        return null;
    }

    @Override
    public String test(HelloObject object) {
        return null;
    }
}
