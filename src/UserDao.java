import java.util.Optional;
import java.util.Set;

public interface UserDao {

        Optional<User> getUser(int id);

        Set<User> getAllUsers();

        User getUserByUserNameAndPassword(String user, String password);

        boolean insertUser();

        boolean updateUser();

        void updateUserPassword(int id, String newpass);

        boolean deleteUser();
    }


