package com.pradip.books;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Pradip on 2/8/2015.
 */
public class HibernateUtil {

    private  static SessionFactory sessionFactory=buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory buildSessionFactory()
    {
    //return new Configuration().configure().buildSessionFactory();
      Configuration configuration=new Configuration();
        configuration.configure();
        serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

public static SessionFactory getSessionFactory()
{
return sessionFactory;
}

}
