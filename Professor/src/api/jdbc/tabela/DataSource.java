package api.jdbc.tabela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSource {
  private static Connection con = null;

  private DataSource() {}

  public static void closeConnection() throws DaoException {
    try {
      if(con != null)
        con.close();
    }
    catch(SQLException e) {
      throw new DaoException(e.getMessage());
    }
  }

  public static Connection getConnection() throws DaoException {
    if(con == null) 
      throw new DaoException("A conexao nao foi inicializada!\n" +
        "Utilize DataSource.getConnection(\"configurcao\")");

    return con;
  }

  public static Connection getConnection(String cfg) throws DaoException {
    try {
      if(con == null) {
        ResourceBundle rb = ResourceBundle.getBundle(cfg);

        String url = rb.getString("db.url");
        String driver = rb.getString("db.driver");
        String userid = rb.getString("db.userid");
        String passwd = rb.getString("db.passwd");

        Class.forName(driver);
        con = DriverManager.getConnection(url, userid, passwd);
      }
      return con;
    }
    catch(ClassNotFoundException e) {
      throw new DaoException(e.getMessage());
    }
    catch(SQLException e) {
      throw new DaoException(e.getMessage());
    }
  }
}