package thrift.demo;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/3/26 下午4:11
 */

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thrift_demo.UserService;
public class UserServiceImpl implements UserService.Iface {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String HUYANSHI = "BDP测试~~~";

    @Override
    public String getName(int id) throws TException {
        logger.info("received getName, id = {}:", id);
        return HUYANSHI;
    }

    @Override
    public boolean isExist(String name) throws TException {
        logger.info("receive isExist, name = {}", name);
        return HUYANSHI.equals(name);
    }
}

