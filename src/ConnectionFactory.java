import java.sql.*;

public class ConnectionFactory {


    public static final String URL = System.getenv("url");
    public static final String USER = System.getenv("user");
    public static final String PASSWORD = System.getenv("password");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args) throws SQLException {

        getConnection();
        UserDao userdao = new UserDaoImpl();
        System.out.println(userdao.getUser(2));
        userdao.updateUserPassword(1, "kefe");
        userdao.printUser();

//            Connection connection = getConnection();
//
//
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("SELECT name FROM USER");
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("name"));
//            }
//
//            PreparedStatement ps = connection.prepareStatement("SELECT name, password FROM user");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                System.out.println("név: " + rs.getString("name") + " pass: " + rs.getString("password"));
//
//            }
//            statement.close();
//            resultSet.close();
//            connection.close();
//
//
//
//            try(Statement stm = getConnection().createStatement();
//                ResultSet rS = stm.executeQuery("SELECT * FROM user");
//            ){
//                while (rS.next()){
//                    System.out.println("felhasz név: " + rS.getString("name"));
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }


    }
}


