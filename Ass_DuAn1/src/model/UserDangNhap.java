package model;

import java.util.ArrayList;
import java.util.List;

public class UserDangNhap {

    List<User> lis = new ArrayList<>();

    public UserDangNhap() {
        lis.add(new User("admin", "1234", true));
        lis.add(new User("quang", "1236", true));
        lis.add(new User("admin1", "123", true));
        lis.add(new User("admin2", "1235", true));

    }

    public boolean checkLogin(String username, String passwword) {
        for (User u : lis) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(passwword)) {
                return true;
            }
            
        }
        return false;
    }
}
