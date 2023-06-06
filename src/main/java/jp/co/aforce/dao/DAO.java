package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
    private static DataSource ds;

    static {
        try {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/member_information");
        } catch (NamingException e) {
            e.printStackTrace();
            // 初期化失敗時の例外処理を追加することをおすすめします
        }
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
