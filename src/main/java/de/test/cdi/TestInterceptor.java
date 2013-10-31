package de.test.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * User: Dmitry Volkov
 * Date: 06.08.13
 * Time: 10:43
 */
@ApplicationScoped
@Interceptor
@Intercepted
@Default
public class TestInterceptor implements Serializable {

    @Inject
    private BeanUsedByInterceptor beanUsedByInterceptor;

    @AroundInvoke
    public Object intercept(final InvocationContext ctx) throws Exception {
        System.out.println(beanUsedByInterceptor.getProperty());
        return ctx.proceed();
    }
}
