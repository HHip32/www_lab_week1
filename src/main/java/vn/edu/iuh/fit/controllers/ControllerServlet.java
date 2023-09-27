package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.models.Role;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;
import vn.edu.iuh.fit.repositories.LogRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/control")
public class ControllerServlet extends HttpServlet {

    private final AccountRepository accountRepository = new AccountRepository();
    private final GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
    private final RoleRepository roleRepository = new RoleRepository();
    private final LogRepository logRepository = new LogRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        List<Account> accounts;
        Account account = (Account) session.getAttribute("accountLogin");
        try {
            accounts = accountRepository.selectAllAccountNotIncludeAdmin(account.getAccountId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        GrantAccess grantAccess = grantAccessRepository.selectGrantAccess(account.getAccountId());
        Role role = roleRepository.selectRole(grantAccess.getRoleId().getRoleId());
        session.setAttribute("role", role);
        session.setAttribute("accounts", accounts);
        resp.setContentType("text/html");
        switch (action) {
            case "infomation":
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                break;
            case "informationOfUser":
                req.getRequestDispatcher("info.jsp").forward(req, resp);
                break;
            case "listRole":
                req.getRequestDispatcher("role.jsp").forward(req, resp);
                break;
            case "listRoleOfUser":
                req.getRequestDispatcher("roleUser.jsp").forward(req, resp);
                break;
            case "logout":
                String email = (String) session.getAttribute("loggedInUserEmail");
                Account acc = accountRepository.selectAccountByEmail(email);

                try {
                    logRepository.updateLogs(acc.getAccountId(), LocalDateTime.now());
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect("index.jsp");
                break;
            case "update":
                Account accUpdate = accountRepository.selectAccount(req.getParameter("id"));
                session.setAttribute("accUpdate", accUpdate);
                resp.sendRedirect("updateAccount.jsp");
                break;
            case "delete":
                try {
                    if (accountRepository.deleteAccount(req.getParameter("id"))) {
//                        req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
//                        req.getRequestDispatcher("control?action=infomation").forward(req, resp);
                        resp.sendRedirect("control?action=infomation");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        resp.setContentType("text/html");
        switch (action) {
            case "login":
                try {
                    login(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addAccount":

                addAccount(req, resp);
                break;
            case "updateAccount":

                updateAccount(req, resp);
                break;
        }

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ClassNotFoundException {
        HttpSession session = req.getSession();
        String email = req.getParameter("username");
        String pass = req.getParameter("password");

        Account account = accountRepository.checkLogin(email, pass);

        if (account != null) {
            List<Account> accounts;
            try {
                accounts = accountRepository.selectAllAccountNotIncludeAdmin(account.getAccountId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            GrantAccess grantAccess = grantAccessRepository.selectGrantAccess(account.getAccountId());
            session.setAttribute("grantAccess", grantAccess);
            session.setAttribute("accountLogin", account);
            session.setAttribute("accounts", accounts);
            session.setAttribute("loggedInUserEmail", email);
            if (grantAccess.getRoleId().getRoleId().equalsIgnoreCase("user")) {
                logRepository.insertLogs(accountRepository.selectAccountByEmail(email).getAccountId(), LocalDateTime.now());
                resp.sendRedirect("info.jsp");
            } else if (grantAccess.getRoleId().getRoleId().equalsIgnoreCase("admin")) {
                logRepository.insertLogs(accountRepository.selectAccountByEmail(email).getAccountId(), LocalDateTime.now());
                resp.sendRedirect("dashboard.jsp");
            }

        } else {
            String errorMessage = "Tài khoản không tồn tại.";
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            // Xuất mã JavaScript để hiển thị thông báo lỗi
            out.println("<script type='text/javascript'>");
            out.println("alert('" + errorMessage + "');");
            out.println("window.location.href='" + req.getContextPath() + "/index.jsp';");
            out.println("</script>");
        }

    }

    public void addAccount(HttpServletRequest req, HttpServletResponse resp) {
        String accID = req.getParameter("AccountID");
        String fullname = req.getParameter("Fullname");
        String pass = req.getParameter("Password");
        String email = req.getParameter("Email");
        String phone = req.getParameter("Phone");
        Account account = new Account(accID, fullname, pass, email, phone, 1);
        try {
            if (accountRepository.insertAccount(account)) {
                String errorMessage = "Thêm tài khoản thành công!";
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();

                // Xuất mã JavaScript để hiển thị thông báo lỗi
                out.println("<script type='text/javascript'>");
                out.println("alert('" + errorMessage + "');");
                out.println("window.location.href='" + req.getContextPath() + "/addAccount.jsp';");
                out.println("</script>");

//                resp.sendRedirect("dashboard.jsp");
                resp.sendRedirect("control?action=infomation");
            } else {
                String errorMessage = "Thêm tài khoản thất bại!";
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();

                // Xuất mã JavaScript để hiển thị thông báo lỗi
                out.println("<script type='text/javascript'>");
                out.println("alert('" + errorMessage + "');");
                out.println("window.location.href='" + req.getContextPath() + "/addAccount.jsp';");
                out.println("</script>");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(HttpServletRequest req, HttpServletResponse resp) {
        String accID = req.getParameter("AccountID");
        String fullname = req.getParameter("Fullname");
        String pass = req.getParameter("Password");
        String email = req.getParameter("Email");
        String phone = req.getParameter("Phone");
        Account account = new Account(accID, fullname, pass, email, phone, 1);
        try {
            if (accountRepository.updateAccount(account)) {


                resp.sendRedirect("control?action=infomation");

            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}