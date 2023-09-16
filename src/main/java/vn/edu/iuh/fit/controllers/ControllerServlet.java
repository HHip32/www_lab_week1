package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/control")
public class ControllerServlet extends HttpServlet {

    private AccountRepository accountRepository = new AccountRepository();
    private GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
    private RoleRepository roleRepository = new RoleRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        resp.setContentType("text/html");
        if ("login".equals(action)) {
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


                if (grantAccess.getRoleId().getRoleId().equalsIgnoreCase("user")) {
                    req.setAttribute("grantAccess", grantAccess);
                    req.setAttribute("account", account);
                    req.getRequestDispatcher("info.jsp").forward(req, resp);
                } else if (grantAccess.getRoleId().getRoleId().equalsIgnoreCase("admin")) {
                    req.setAttribute("accounts", accounts);
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                }

            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>Chưa xử lí</h1>");
            out.println("</body></html>");
        }
    }
}