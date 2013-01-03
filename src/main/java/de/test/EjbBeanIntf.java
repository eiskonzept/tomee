package de.test;

import javax.ejb.Local;

@Local
public interface EjbBeanIntf {
    String callMe(String param);
}
