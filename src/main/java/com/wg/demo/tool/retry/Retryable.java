package com.wg.demo.tool.retry;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retryable {

    /**
     * Exception type that are retryable.
     * @return exception type to retry
     */
    Class<? extends Throwable> value() default RuntimeException.class;

    /**
     * 包含第一次失败
     * @return the maximum number of attempts (including the first failure), defaults to 3
     */
    int maxAttempts() default 3;

}
