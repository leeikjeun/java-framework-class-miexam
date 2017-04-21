package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementMaker statementMaker = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return context.contextGetProduct(statementMaker);
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        StatementMaker statementMaker = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into product(id,title,price) VALUES (?,?,?)");
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2,product.getTitle());
            preparedStatement.setInt(3,product.getPrice());
            return preparedStatement;
        };
        context.contextUpdate(statementMaker);
    }

    public void update(Product product) throws SQLException {
        StatementMaker statementMaker = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id = ?");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setLong(3,product.getId());
            return preparedStatement;
        };
        context.contextUpdate(statementMaker);
    }


    public void delete(Long id) throws SQLException {
        StatementMaker statementMaker = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        context.contextUpdate(statementMaker);
    }
}
