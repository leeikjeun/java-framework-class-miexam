package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public interface StatementMaker {
    public PreparedStatement prepareStatement(Connection connection) throws SQLException;
}
