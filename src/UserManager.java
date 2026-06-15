import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;
    private static UserManager instance = new UserManager();

    private UserManager() {
        users = new HashMap<>();
    }

    public static UserManager getInstance() {
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUserById(String id) {
        return users.get(id);
    }
}
