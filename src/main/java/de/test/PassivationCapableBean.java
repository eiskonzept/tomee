package de.test;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;

@Named
@WindowScoped
public class PassivationCapableBean implements Serializable {

    private String stringValue;
    private Integer intValue;

    //@EJB
    //private EjbBeanIntf ejbBean;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String submit(){
        System.out.println("test");
        return null;
    }
}
