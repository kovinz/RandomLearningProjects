package ru.ifmo.servlets;

import ru.ifmo.repositories.UsersRepository;
import ru.ifmo.repositories.UsersRepositoryInMemoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  // ссылка на хранилище пользователей
  private UsersRepository usersRepository;

  @Override
  public void init() throws ServletException {
    this.usersRepository = new UsersRepositoryInMemoryImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // вытаскиваем из запроса имя пользователя и его пароль
    String name = req.getParameter("name");
    String password = req.getParameter("password");

    // если пользователь есть в системе
    if (usersRepository.exists(name, password)) {
      // создаем для него сессию
      HttpSession session = req.getSession();
      // кладем в атрибуты сессии атрибут user с именем пользователя
      session.setAttribute("user", name);
      // перенаправляем на страницу home
      req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
//      Cookie userCookie = new Cookie("user", name);
//      // кладем в ответ
//      resp.addCookie(userCookie);
//      // перенаправляем пользователя обратно на страницу home
//      resp.sendRedirect(req.getContextPath() + "/home");
    } else {
      resp.sendRedirect(req.getContextPath() + "/login");
    }

  }
}