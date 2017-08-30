package zlh.test.annotation;

import java.lang.reflect.Field;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/*********** 输出结果 ***************/
public class FruitRun {

    /**
     * @param args
     */
    public static void main(String[] args) {

        FruitInfoUtil.getFruitInfo(Apple.class);
        Apple apple = new Apple(5, "hongfushi", "blue", "asdfasdf");
        Field[] fields = apple.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fn = (FruitProvider) field.getAnnotation(FruitProvider.class);
                System.out.println(fn.address());
            }
        }
        System.out.println(apple.getAppleColor());
        System.out.println(apple.getAppleProvider());

        // http://tanlan.iteye.com/blog/1099523
        // 测试失败，不能实现

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Apple>> constraintViolations = validator.validate(apple);
        for (ConstraintViolation<Apple> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }

    }
}