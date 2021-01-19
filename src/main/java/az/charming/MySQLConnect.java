package az.charming;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {
    public static void connect(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String host = "sql7.freemysqlhosting.net";
            String port = "3306";
            String db = "sql7387887";
            String username = "sql7387887";
            String password = "sgyKgwscUu";
            String conUrl = String.format("jdbc:mysql://%s:%s/%s",host,port,db);
            Connection con= DriverManager.getConnection(conUrl,username,password);
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
