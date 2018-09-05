package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class StudentController {
    public static Student[] students = new Student[100];
    public static int studentIndex = 0;
    public static Scanner KeyIn;
    
    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        
    }
    public static void serviceStudentMenu() {
        while(true) {
            System.out.println("학생 관리 > 추가:add 목록:list 닫기:quit");
            String command = KeyIn.nextLine();
            if(command.equalsIgnoreCase("list")) {
                printStudents();
            }else if(command.equalsIgnoreCase("add")) {
                inputStudents();
            }else if(command.equalsIgnoreCase("quit")) {
                break;
            }
            else {
                System.out.println("유효하지 않는 명령어입니다.");
            }
        }
    }
    
    private static void printStudents() {
        int count = 0;
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            System.out.printf
            ("%s, %s, %s, %s, %b, %s\n", 
                    s.getName(),s.getEmail(),s.getPassword(),s.getSchool(),s.isWorking(),s.getTel());
    }  
    }
    
    private static void inputStudents() {
        while(true) {  
            Student m  = new Student(); 
            
            System.out.print("이름을 입력하세요 :\t");
            m.setName(KeyIn.nextLine());
            
            System.out.print("이메일을 입력하세요 :\t ");
            m.setEmail(KeyIn.nextLine());
            
            System.out.print("암호를 입력하세요 :\t"); 
            m.setPassword(KeyIn.nextLine());
            
            System.out.print("최종학력을 입력하세요 :\t");
            m.setSchool(KeyIn.nextLine());
            
            System.out.print("재직여부: (true/false)\t ");
            m.setWorking(Boolean.parseBoolean(KeyIn.nextLine()));
            
            System.out.print("전화번호를 입력하세요 : \t");
            m.setTel(KeyIn.nextLine());
            
            students[studentIndex++] = m;
            
            System.out.println("계속 하시겠습니까? (Y/n) ");
            
            String answer = KeyIn.nextLine();  
            
            if(answer.toLowerCase().equals("n")) 
                    break;
    }
}
}
