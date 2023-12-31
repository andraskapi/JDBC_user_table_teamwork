import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDaoImpl implements UserDao {

    Scanner sc = new Scanner(System.in);

    @Override
    public void removeUser(int id) {
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("DELETE FROM user WHERE id = ? "))
        {
            ps.setInt(1,id);
            ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> userList = new ArrayList<>();

        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM user"))
        {

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String userName = rs.getString("name");
                if (userName.contains(name)){
                    userList.add(
                     new User(rs.getInt("id"),rs.getString("name"),
                            rs.getString("password"),rs.getInt("age")));
                }
            } return userList;

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void printUser(){

        try(Statement stm = ConnectionFactory.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM user")){
            while (rs.next()){
                System.out.println("id: " + rs.getInt("id") + " name: "+ rs.getString("name") +
                        " age: " + rs.getInt("age"));
            }

        }catch (SQLException e){
           e.printStackTrace();
        }


    }

    @Override
    public Optional<User> getUser(int id) {

        try (Statement stm = ConnectionFactory.getConnection().createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE id = " + id)
        ) {
            if (rs.next()) {
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Optional.empty();
    }


    @Override
    public void updateUserPassword(int id, String newPass) {

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("UPDATE user SET password = ? WHERE id = ? ")) {
            ps.setString(1, newPass);
            ps.setInt(2, id);
            ps.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public Set<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByUserNameAndPassword(String user, String password) {


        return null;
    }

    @Override
    public boolean insertUser() {
        return false;
    }

    @Override
    public boolean updateUser() {
        return false;
    }


    @Override
    public boolean deleteUser() {
        return false;
    }



}