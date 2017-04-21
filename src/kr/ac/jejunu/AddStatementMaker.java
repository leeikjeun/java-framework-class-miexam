package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public class AddStatementMaker implements StatementMaker {
    private Product product;

    public AddStatementMaker(Product product) {
        this.product = product;
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into product(id,title,price) VALUES (?,?,?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2,product.getTitle());
        preparedStatement.setInt(3,product.getPrice());
        return preparedStatement;
    }
}
