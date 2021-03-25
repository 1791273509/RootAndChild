package root;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/3/25 下午2:51
 */
@ConfigurationProperties(prefix = "b")
@Component
public class B implements InitializingBean {
    @Value("${a.b}")
    private int b;

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("ttt" + b);
    }
}
    