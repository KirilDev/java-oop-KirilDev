import java.sql.*;

public class CategoryDAO {
    public void addCategory(String name) {
        String sql = 
        "INSERT INTO categories(name) VALUES (?)";

        try (Connection connection = DatabaseManager.connect();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}