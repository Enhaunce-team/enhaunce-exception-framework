package enhaunce.exceptionframework.annotations;

import enhaunce.exceptionframework.advices.EnhaunceExceptionAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EnhaunceExceptionAdvice.class)
public @interface EnabledEnhaunceExceptionFramework {
}
