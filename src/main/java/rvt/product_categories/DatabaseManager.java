import java.sql.*;

public class DatabaseManager {
    public static final String URL = "jdbc:sqlite:shop.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {
        String categories = """
            CREATE TABLE IF NOT EXISTS categories(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL
            );
        """;

        String products = """
            CREATE TABLE IF NOT EXISTS products(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            price REAL NOT NULL,
            category_id INTEGER,
            FOREIGN KEY(category_id)
            REFERENCES categories(id))
        """;

        try(Connection connection = connect();
    Statement statement = connection.createStatement()) {
        statement.execute(categories);
        statement.execute(products);

    }catch(Exception e) {
        e.printStackTrace();
    }
}
}