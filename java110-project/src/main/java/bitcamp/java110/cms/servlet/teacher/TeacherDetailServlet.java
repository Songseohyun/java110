package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/teacher/detail")
public class TeacherDetailServlet extends HttpServlet{ 

    private static final long serialVersionUID = 1L;
    TeacherMysqlDao teacherDao;
  
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        teacherDao = new TeacherMysqlDao();
        teacherDao.setDataSource(dataSource);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        Teacher m = teacherDao.findByNo(no);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        if (m == null) {
            System.out.println("해당 번호의 매니저가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", m.getName());
        out.printf("이메일: %s\n", m.getEmail());
        out.printf("암호: %s\n", m.getPassword());
        out.printf("과목: [%s]\n" ,m.getSubjects());
        out.printf("전화: %s\n", m.getTel());
        out.printf("Pay: %d\n", m.getPay());
    }
    

    
}
    
    
    
    
    
    
    
    
    
