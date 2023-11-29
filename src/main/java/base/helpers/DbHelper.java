package base.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	
	private final String  DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String  URL = "jdbc:mysql://localhost:3306/mydb";
    private final String  USERNAME = "root";
    private final String  PASSWORD = "root";

    private static Connection connection ;
    private static DbHelper instance = null ;

    private DbHelper(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static DbHelper getInstance() {
        if (instance == null){
            instance = new DbHelper();
        }
        return instance;
    }

}
