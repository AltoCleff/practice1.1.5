package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Ivan", "Petrov", (byte) 22);
        userService.saveUser("Nikolai", "Ivanov", (byte) 45);
        userService.saveUser("Elizaveta", "Smirnova", (byte) 30);
        userService.saveUser("Pavel", "Ryazancev", (byte) 18);

        List<User> userList = userService.getAllUsers();
        userList.stream().forEach((x) -> System.out.println(x.getName()));

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
