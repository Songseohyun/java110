package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherJdbcDao implements TeacherDao {
    
    public int insert(Teacher teacher) {
        Connection con = null;
        Statement stmt = null;
        
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
            
            con.setAutoCommit(false);

            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + teacher.getName()
                    + "','" + teacher.getEmail()
                    + "',password('" + teacher.getPassword()
                    + "'),'" + teacher.getTel()
                    + "',now())";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int no = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            String sql2 = "insert into p1_tchr(tno,hrpay,subj)"
                    + " values(" + no
                    + "," + teacher.getPay()
                    + ",'" + teacher.getSubjects()
                    + "')";
            stmt.executeUpdate(sql2);
            
            con.commit();
            return 1;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
    }
    
    public List<Teacher> findAll() {
        
        ArrayList<Teacher> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " t.hrpay," +
                    " t.subj" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno");
            
            while (rs.next()) {
                Teacher s = new Teacher();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setPay(rs.getInt("hrpay"));
                s.setSubjects(rs.getString("subj"));
                
                list.add(s);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
        return list;
    }
    
    public Teacher findByEmail(String email) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " t.hrpay," +
                    " t.subj" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno" +
                    " where m.email='" + email + "'");
            
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setEmail(rs.getString("email"));
                t.setName(rs.getString("name"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
    }
    
    public Teacher findByNo(int no) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " t.hrpay," +
                    " t.subj" +
                    " from p1_tchr t" + 
                    " inner join p1_memb m on t.tno = m.mno" +
                    " where m.mno=" + no);
            
            if (rs.next()) {
                Teacher t = new Teacher();
                t.setNo(rs.getInt("mno"));
                t.setEmail(rs.getString("email"));
                t.setName(rs.getString("name"));
                t.setTel(rs.getString("tel"));
                t.setPay(rs.getInt("hrpay"));
                t.setSubjects(rs.getString("subj"));
                
                return t;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
    }
    
    public int delete(int no) {
        Connection con = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
            
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql = "delete from p1_tchr where tno=" + no ;
            int count = stmt.executeUpdate(sql);
            
            if (count == 0)
                return 0;
            
            String sql2 = "delete from p1_memb where mno=" + no;
            stmt.executeUpdate(sql2);
            con.commit();
            
            return 1;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
    }
}









