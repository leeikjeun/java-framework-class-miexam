package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public interface ConnetionMaker {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
