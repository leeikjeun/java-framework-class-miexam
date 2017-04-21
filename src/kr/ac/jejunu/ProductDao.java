package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        String sql = "select * from product where id = ?";
        Object[] params = new Object[]{id};
        return context.getProduct(sql, params);
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        String sql = "INSERT into product(id,title,price) VALUES (?,?,?)";
        Object[] params = new Object[]{product.getId(),product.getTitle(),product.getPrice()};
        context.update(sql, params);
    }

    public void update(Product product) throws SQLException {
        String sql = "update product set title = ?, price = ? where id = ?";
        Object[] params = new Object[]{product.getTitle(),product.getPrice(),product.getId()};
        context.update(sql, params);
    }


    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM product where id = ?";
        Object[] params = new Object[]{id};
        context.update(sql, params);
    }


}
