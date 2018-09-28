// Refresh
// 서버가보낸 콘텐트를 Client가 출력한 후에
// 지정한 URL로 자동으로 요청하게 만드는 기술

package bitcamp.java110.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse res) 
            throws ServletException, IOException {
        
     // 방법 1)
        // => 응답 헤더에 Refresh 명령을 추가하기
        // => 다음은 응답 내용을 출력한 후 2초 후에 http://google.com을 요청 하라는 명령
        //res.setHeader("Refresh", "2;url=http://google.com");
    
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        // 방법 2)
        // HTML의 <meta> 태그에 Refresh 명령을 설정할 수 있다.
        // 메타 데이터는 헤드 태그 안에 넣어야 한다.
        out.println("<meta http-equiv='Refresh' content='5;url=http://google.com'>");  
        
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex08</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet01 실행!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        
    }
}

/*
HTTP/1.1 200
Content-Type: text/html;charset=UTF-8
Content-Length: 204
Date: Fri, 28 Sep 2018 05:34:27 GMT
 */





























