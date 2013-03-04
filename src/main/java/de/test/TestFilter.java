package de.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * User: Dmitry
 * Date: 21.02.13
 * Time: 16:42
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SessionScopedBean.staticMethod();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
