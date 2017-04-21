package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public class GetStatementMaker implements StatementMaker {
    private Long id;

    public GetStatementMaker(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
