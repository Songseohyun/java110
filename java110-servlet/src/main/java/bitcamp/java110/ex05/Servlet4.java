/* GET/POST 구분하기 IV
 * 
*/
package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// MyHttpServlet을 직접 상속 받는 것 보다
// MyHttpServlet2 클래스를 상속 받으면 
// GET/POST 요청을 구분 하여 처리 할 수 있다

@WebServlet("/ex05/servlet04")
public class Servlet4 extends  HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("GET 요청 입니다");

    }
    
    
}
