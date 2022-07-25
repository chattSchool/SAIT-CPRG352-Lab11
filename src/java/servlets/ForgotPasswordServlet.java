package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author Dakota Chatt
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        session.setAttribute("message", null);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        
        if(email == null || email.equals("")) {
            String message = "Please enter your email address";
            request.setAttribute("message", message);
        } else {
            AccountService as = new AccountService();
            String path = getServletContext().getRealPath("/WEB-INF");
            boolean forgotPassEmailed = as.forgotPassword(email, path);
            
            String message = "If the email you entered is valid, you will receive an email shortly.";
            session.setAttribute("message", message);
        }
        
        response.sendRedirect("forgot");
        return;
    }
}
