package zlh.test.annotation.valid;
/*
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.gwi.drive.common.bval.annotation.NotBlank;



public class NotBlankValidator implements ConstraintValidator<NotBlank, Object> {
    
    
    @Override
    public void initialize(NotBlank notBlank) {
    	
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null)
        	return false;
        
        if(value instanceof String){
        	return !StringUtils.isBlank(((String) value).trim());
        }
        return true;
    }

}
*/