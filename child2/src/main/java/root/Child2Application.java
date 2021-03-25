package root;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:application-demo1-dev.properties", "classpath:application.properties"})
public class Child2Application implements InitializingBean {

    @Autowired
    private A a;
    @Autowired
    private B b;

    public static void main(String[] args) {
        SpringApplication.run(Child2Application.class, args);
    }

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println(a.getB());
        System.out.println(b.getB());
    }
}
