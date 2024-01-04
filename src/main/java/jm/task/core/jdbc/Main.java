package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Vlad", "Ivanov", (byte) 34);
        userService.saveUser("Andrew", "Kastrov", (byte) 15);
        userService.saveUser("Oleg", "Zybenko", (byte) 29);
        userService.saveUser("Dima", "Petrov", (byte) 145);

        userService.getAllUsers();

        userService.removeUserById(2);

        System.out.println("--------------------------------");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        System.out.println("--------------------------------");

        userService.dropUsersTable();
    }
}
