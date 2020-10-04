package ru.ivmiit.mvc.app;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.ivmiit.mvc.dao.UsersDao;
import ru.ivmiit.mvc.dao.UsersDaoJdbcTemplateImpl;
import ru.ivmiit.mvc.models.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 18.04.2018
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("qwe123");
        dataSource.setUrl("jdbc:mysql://localhost:3306/users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        UsersDao usersDao = new UsersDaoJdbcTemplateImpl(dataSource);

        List<User> users = usersDao.findAll();

        System.out.println(users);
    }
}
