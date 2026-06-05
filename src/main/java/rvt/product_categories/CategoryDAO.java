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

    public void showCategories() {
        String sql = 
        "SELECT * FROM categories";
        try (Connection connection = DatabaseManager.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id")
                    + " - "
                    + resultSet.getString("name")
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}