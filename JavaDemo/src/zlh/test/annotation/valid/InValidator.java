package zlh.test.annotation.valid;
/*
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
public class InValidator implements ConstraintValidator<In, String> {

    private String rules;

    @Override
    public void initialize(In in) {
        this.rules = in.rules();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(rules)) {
            return true;
        }

        String[] equalArray = rules.split(",");
        for (String string : equalArray) {
            if (value.equals(string)) {
                return true;
            }
        }

        return false;
    }

}
*/