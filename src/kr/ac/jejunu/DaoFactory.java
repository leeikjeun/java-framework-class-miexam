package kr.ac.jejunu;

/**
 * Created by adaeng on 2017. 4. 21..
 */
public class DaoFactory {

    public ProductDao productDao() {
        return new ProductDao(ConnetionMaker());
    }

    public ConnetionMaker ConnetionMaker() {
        return new JejuConnetionMaker();
    }
}
