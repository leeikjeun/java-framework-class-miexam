package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public class Context {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Product contextGetProduct(StatementMaker statementMaker) throws SQLException {
        Product product = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = statementMaker.prepareStatement(connection);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getInt("price"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
        }
        return product;
    }

    public void contextUpdate(StatementMaker statementMaker) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = statementMaker.prepareStatement(connection);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
        }
    }

    public Product getProduct(String sql, Object[] params) throws SQLException {
        StatementMaker statementMaker = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i = 1; i <= params.length; i++){
                preparedStatement.setObject(i,params[i-1]);
            }
            return preparedStatement;
        };
        return contextGetProduct(statementMaker);
    }

    public void update(String sql, Object[] params) throws SQLException {
        StatementMaker statementMaker = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i = 1; i <= params.length; i++){
                preparedStatement.setObject(i,params[i-1]);
            }
            return preparedStatement;
        };
        contextUpdate(statementMaker);
    }
}
