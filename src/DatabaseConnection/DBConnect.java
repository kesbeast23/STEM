package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kesego
 */
public class DBConnect {
    
      private static Connection con = null;

    public static Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stem", "root", "");
            return con;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
