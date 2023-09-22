package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.checkerframework.checker.units.qual.A;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;
import vn.edu.iuh.fit.repositories.LogRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/control")
public class ControllerServlet extends HttpServlet {

    private AccountRepository accountRepository = new AccountRepository();
    private GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
    private RoleRepository roleRepository = new RoleRepository();
    private LogRepository logRepository = new LogRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = accountRepository.selectAllAccount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.setContentType("text/html");
        switch (action) {
            case "infomation":
                session.setAttribute("accounts", accounts);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                break;
            case "listRole":



                session.setAttribute("accounts", accounts);
                req.getRequestDispatcher("role.jsp").forward(req, resp);
                break;
            case "logout":
                String email = (String) session.getAttribute("loggedInUserEmail");
                Account acc = accountRepository.selectAccountByEmail(email);

                try {
                    logRepository.updateLogs(acc.getAccountId(), LocalDateTime.now());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                resp.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        resp.setContentType("text/html");
        switch (action) {
            case "login":
                try {
                    login(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = req.getSession();
        String email = req.getParameter("username");
        String pass = req.getParameter("password");

        Account account = accountRepository.checkLogin(email, pass);
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = accountRepository.selectAllAccount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (account != null) {
            GrantAccess grantAccess = grantAccessRepository.selectGrantAccess(account.getAccountId());
            session.setAttribute("grantAccess", grantAccess);
            session.setAttribute("account", account);
            session.setAttribute("accounts", accounts);
            session.setAttribute("loggedInUserEmail", email);
            if (grantAccess.getRoleId().getRoleId().equalsIgnoreCase("user")) {
                logRepository.insertLogs(accountRepository.selectAccountByEmail(email).getAccountId(), LocalDateTime.now());
                req.getRequestDispatcher("info.jsp").forward(req, resp);
            } else if (grantAccess.getRoleId().getRoleId().equalsIgnoreCase("admin")) {
                logRepository.insertLogs(accountRepository.selectAccountByEmail(email).getAccountId(), LocalDateTime.now());
                resp.sendRedirect("dashboard.jsp");
            }

        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}