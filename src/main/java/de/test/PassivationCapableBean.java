package de.test;

import de.test.cdi.BeanUsedByInterceptor;
import de.test.cdi.Intercepted;
import de.test.cdi.TestInterceptor;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;
import org.apache.myfaces.extensions.cdi.core.impl.projectstage.ProjectStageProducer;
import org.apache.myfaces.extensions.cdi.jsf.impl.scope.conversation.spi.EditableWindowContext;
import org.apache.myfaces.extensions.cdi.jsf2.impl.request.DefaultRequestTypeResolver;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class PassivationCapableBean extends AbstractDelegatingMap implements Serializable {

    private String stringValue;
    private Integer intValue;


    @Inject
    private BeanUsedByInterceptor bean;

    @EJB
    private EjbBeanIntf ejbBean;

    @Intercepted
    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Intercepted
    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    @Intercepted
    public String submit(){
        System.out.println("submit");
        return null;
    }

    @Override
    protected Map<String, Serializable> initDelegate() {
        return new HashMap<String, Serializable>();
    }
}
