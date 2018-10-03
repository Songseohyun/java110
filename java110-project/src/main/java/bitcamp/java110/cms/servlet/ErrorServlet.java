package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
>>>>>>> 4b2bd7d49cb557ed277fec29981b70ca37abaa28
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        Exception e = (Exception) request.getAttribute("error");
        String message = (String) request.getAttribute("message");
        String refresh = (String) request.getAttribute("refresh");
        
        if (refresh != null) {
            response.setHeader("Refresh", refresh);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>실행 오류</title>");
        out.println("</head>");
        out.println("<body>");
<<<<<<< HEAD
        
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.printf("<h1>%s</h1>\n", message);
        out.printf("<p>%s</p>\n", e.getMessage());
        out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
        
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        
=======
        out.printf("<h1>%s</h1>\n", message);
        out.printf("<p>%s</p>\n", e.getMessage());
        out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
>>>>>>> 4b2bd7d49cb557ed277fec29981b70ca37abaa28
        out.println("</body>");
        out.println("</html>");
    }
}














