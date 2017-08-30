package zlh.test.annotation.valid;
/*
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.gwi.drive.common.constant.ValidtErrorConstants;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
// 约束注解应用的目标元素类型
@Retention(RetentionPolicy.RUNTIME)
// 约束注解应用的时机
@Documented
@Constraint(validatedBy = { NotBlankValidator.class })
// 与约束注解关联的验证器
public @interface NotBlank {

    // 约束注解验证时的默认输出消息
    String message() default ValidtErrorConstants.PARAM_BLANK_ERR;

    // 分组,约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 负载,约束注解的有效负载
    Class<? extends Payload>[] payload() default {};

}
*/