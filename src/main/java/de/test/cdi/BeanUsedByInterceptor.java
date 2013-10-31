package de.test.cdi;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * User: Dmitry Volkov
 * Date: 31.10.13
 * Time: 10:51
 */
@ApplicationScoped
public class BeanUsedByInterceptor implements Serializable {
    private String property = "Property from bean used by interceptor";

    //Not serializable field
    private Logger logger = Logger.getLogger("test");


    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
