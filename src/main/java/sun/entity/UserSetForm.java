package sun.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunlei19
 * @create 2018-06-02 16:30
 */
public class UserSetForm {
    Set<Admin> users;

    private UserSetForm() {
        users = new HashSet<>();
        users.add(new Admin());
        users.add(new Admin());
    }

    public Set<Admin> getUsers() {
        return users;
    }

    public void setUsers(Set<Admin> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserSetForm{" +
                "users=" + users +
                '}';
    }
}
