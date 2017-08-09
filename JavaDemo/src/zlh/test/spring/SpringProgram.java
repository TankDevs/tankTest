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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");// ��ȡbean.xml�е�����
        Person p = ctx.getBean("person", Person.class);// ����bean�����ö���
        p.info();
        // ctx.close();

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringProgram.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.pringMessage();

    }
}
