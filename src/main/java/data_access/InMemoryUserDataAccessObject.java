package data_access;

import java.util.HashMap;
import java.util.Map;

import entity.User;
import use_case.change_password.ChangePasswordUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * DAO for the in memory.
 */
public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    private String currentUser = null;

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void setCurrentUser(String name) {
        this.currentUser = name;
    }

    @Override
    public String getCurrentUser() {
        return currentUser;
    }

    @Override
    public void changePassword(User user) {
        users.put(user.getName(), user);
    }
}
