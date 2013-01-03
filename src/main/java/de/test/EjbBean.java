package de.test;

import javax.ejb.Stateful;

@Stateful
public class EjbBean implements EjbBeanIntf {
    @Override
    public String callMe(String param) {
        System.out.println(param);
        return param + "_return";
    }
}
