package sun.entity;

import java.util.Map;

/**
 * @author sunlei19
 * @create 2018-06-02 16:54
 */
public class UserMapform {
    private Map<String, Admin> users;

    public Map<String, Admin> getUsers() {

        return users;
    }

    public void setUsers(Map<String, Admin> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserMapform{" +
                "users=" + users +
                '}';
    }
}
