package de.test;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * User: dmitry
 * Date: 08.02.13
 * Time: 18:09
 */
@Named
@SessionScoped
public class SessionScopedBean implements Serializable {
    private String sessionString;

    public static void staticMethod() {
        System.out.println("Static Method");
    }

    public String getSessionString() {
        return sessionString;
    }

    public void setSessionString(String sessionString) {
        this.sessionString = sessionString;
    }
}
