package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public class JejuConnetionMaker implements ConnetionMaker {
    String className;
    String url;
    String user;
    String password;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(className);
        return DriverManager.getConnection(url, user, password);
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
