package sun.entity;

import java.util.List;

/**
 * @author sunlei19
 * @create 2018-06-02 16:24
 */
public class UserListForm {
    private List<Admin> users;

    public List<Admin> getUsers() {
        return users;
    }

    public void setUsers(List<Admin> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }
}
