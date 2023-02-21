package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/practice1.1.5";
    private static final String USERNAME = "AltoCleff";
    private static final String PASSWORD = "root";


    private static final Util util = new Util();

    private static SessionFactory factory;

    private Util() {
        Properties settings = new Properties();
        settings.put(Environment.URL, URL);
        settings.put(Environment.USER, USERNAME);
        settings.put(Environment.PASS, PASSWORD);
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        factory = new Configuration()
                .addProperties(settings)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static Util getUtil() {
        return util;
    }

    public SessionFactory getFactory() {
        return factory;
    }

}
