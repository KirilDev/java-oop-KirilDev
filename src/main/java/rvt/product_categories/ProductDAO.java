public class ProductDAO {
    public void addProduct(
        String name,
        double price,
        int categoryId) 
    {
        String sql = """
            INSERT INTO products
            (name, price, category_id)
            VALUES (?, ?, ?)
            """;

            try (Connection connection = DatabaseManager.connect();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.setInt(3, categoryId);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}