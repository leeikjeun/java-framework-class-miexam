package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public class UpdateStatementMaker implements StatementMaker {
    private Product product;

    public UpdateStatementMaker(Product product) {
        this.product = product;
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id = ?");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2,product.getPrice());
        preparedStatement.setLong(3,product.getId());
        return preparedStatement;
    }
}
