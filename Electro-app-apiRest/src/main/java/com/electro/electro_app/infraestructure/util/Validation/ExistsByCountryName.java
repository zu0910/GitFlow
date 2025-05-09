package com.electro.electro_app.infraestructure.util.Validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByCountryNameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByCountryName{

    String message() default "Ya existe en la base de datos, escoja otro username!";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

}
