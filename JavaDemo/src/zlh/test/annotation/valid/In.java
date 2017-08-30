
package zlh.test.annotation.valid;
/*
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
// 约束注解应用的目标元素类型
@Retention(RetentionPolicy.RUNTIME)
// 约束注解应用的时机
@Documented
@Constraint(validatedBy = { InValidator.class })
// 与约束注解关联的验证器
public @interface In {
    // 自定义校验规则
    String rules() default StringUtils.EMPTY;

    // 约束注解验证时的默认输出消息
    String message() default "参数不在匹配范围内";

    // 分组,约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 负载,约束注解的有效负载
    Class<? extends Payload>[] payload() default {};

}
*/