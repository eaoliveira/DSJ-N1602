import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteAcessoExcel {
	public static void main(String[] args) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager
					.getConnection("jdbc:odbc:TesteExcel");
			Statement sql = con.createStatement();
			ResultSet res = sql.executeQuery("select * from [Sheet1$]");
			while (res.next()) {
				System.out.println("Mes: " + res.getString(1) + " Valor: "
						+ res.getInt(2) + " Taxa: " + res.getDouble(3));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
