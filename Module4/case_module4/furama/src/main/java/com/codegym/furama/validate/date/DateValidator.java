package com.codegym.furama.validate;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class DateValidator implements ConstraintValidator<DateConstaint, String> {

   @Autowired
   private ICustomerService customerService;

   public void initialize(DateConstaint constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      if (!obj.equals("")) {
         String[] dateYears = obj.split("-");
         String dateYear = dateYears[0];
         return Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(dateYear) >= 18;
      }
      return true;
   }
}
