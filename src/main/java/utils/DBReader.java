package utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASSWORD = "postgres";
    private final static String QUERY_SELECT_ALL = "select * from shop";
    private final static String QUERY_INSERT = "insert into shop values(?,?,?,?)";
    private final static String QUERY_UPDATE = "update shop set countOfProduct=? where id=?";
    private final static String QUERY_DELETE = "delete from shop where id=?";

    public static List<Shop> getItemsFromDB() {
        List<Shop> shop1 = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            Statement sqlStatement = connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(QUERY_SELECT_ALL);


            while (resultSet.next()) {
                Shop shop = new Shop(resultSet.getString("item"), resultSet.getInt("countOfProduct"), resultSet.getInt("priceOfProduct"));
                shop1.add(shop);
            }

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
        return shop1;
    }

    /*public static void insert(int id, String item, int countOfProduct, int priceOfProduct) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(5, 5);
            preparedStatement.setString(5, "water-gun");
            preparedStatement.setInt(5, 10);
            preparedStatement.setInt(5, 45);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }

    public static void update(int id, String item, int countOfProduct, int priceOfProduct) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(4, countOfProduct);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }

    public static void delete(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }*/
    public static void main(String[] args) {
        getItemsFromDB();
    }
}