package zlh.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;;;

@Configuration
@ComponentScan
public class SpringProgram {
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello Spring";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");// 读取bean.xml中的内容
        Person p = ctx.getBean("person", Person.class);// 创建bean的引用对象
        p.info();
        // ctx.close();

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringProgram.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.pringMessage();

    }
}
