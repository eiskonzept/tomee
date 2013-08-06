package de.test.cdi;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * User: Dmitry Volkov
 * Date: 06.08.13
 * Time: 10:43
 */
@Interceptor
@Intercepted
public class TestInterceptor implements Serializable {
    @AroundInvoke
    public Object intercept(final InvocationContext ctx) throws Exception {
        System.out.println("Intercepting");
        return ctx.proceed();
    }
}
