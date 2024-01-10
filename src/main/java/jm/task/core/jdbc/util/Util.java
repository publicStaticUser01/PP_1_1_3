package jm.task.core.jdbc.util;


import java.util.Properties;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
        private static final String HOST = "jdbc:mysql://localhost:3306/base";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "1111";
        private Connection connection;
        static SessionFactory sessionFactory;


        public Connection getConnection() {
            try {
                connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

        public static SessionFactory getConnectionHibernate() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();
                    Properties settings = new Properties();
                    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                    settings.put(Environment.URL, HOST);
                    settings.put(Environment.USER, USERNAME);
                    settings.put(Environment.PASS, PASSWORD );
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                    settings.put(Environment.SHOW_SQL, "true");
                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                    settings.put(Environment.HBM2DDL_AUTO, "");

                    configuration.setProperties(settings);
                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return sessionFactory;
        }

}

