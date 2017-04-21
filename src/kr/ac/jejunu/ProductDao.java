package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {

    private Context context;
    
    public void setContext(Context context) {
        this.context = context;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementMaker statementMaker = new GetStatementMaker(id);
        return context.contextGetProduct(statementMaker);
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        StatementMaker statementMaker = new AddStatementMaker(product);
        context.contextUpdate(statementMaker);
    }

    public void update(Product product) throws SQLException {
        StatementMaker statementMaker = new UpdateStatementMaker(product);
        context.contextUpdate(statementMaker);
    }


    public void delete(Long id) throws SQLException {
        StatementMaker statementMaker = new DeleteStatementMaker(id);
        context.contextUpdate(statementMaker);
    }
}
