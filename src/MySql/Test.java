package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {

//        数据库配置
        String dbName = "Test";
        String url = "jdbc:mysql://localhost:3306/";
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String username = "root";
        String password = "root123";

        try {
//            加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

//            链接数据库
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL server");

            // 创建数据库如果不存在
            Statement stmt = conn.createStatement();
            String createDbQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(createDbQuery);
            System.out.println("Database created or already exists");

            // 连接到数据库
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to the database " + dbName);

            // 创建表如果不存在
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Main ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100) NOT NULL)";
            stmt = conn.createStatement();
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table created or already exists");

            // 关闭连接
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("driver not found" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e.getMessage());
        }
    }
}
