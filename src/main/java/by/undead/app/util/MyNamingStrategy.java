package by.undead.app.util;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 16.01.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public class MyNamingStrategy extends DefaultNamingStrategy {

    @Override
    public String classToTableName(String className) {
        return "T_" + super.classToTableName(className);    //To change body of overridden methods use File | Settings | File Templates.
    }
}

