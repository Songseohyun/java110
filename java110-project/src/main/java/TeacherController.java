import java.util.Scanner;

public class TeacherController {
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    static Scanner KeyIn;
    
    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
        
    }
    
    static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사 관리 > 추가:add 목록:list 닫기:quit");
            String command = KeyIn.nextLine();
            if(command.equalsIgnoreCase("list")) {
                printTeachers();
            }else if(command.equalsIgnoreCase("add")) {
                inputTeachers();
            }else if(command.equalsIgnoreCase("quit")) {
                break;
            }
            else {
                System.out.println("유효하지 않는 명령어입니다.");
            }
        }
    }
    static void printTeachers() {
        int count = 0;
        for(Teacher s : teachers) {
            if(count++ == teacherIndex)
                break;
            System.out.printf
            ("%s, %s, %s, %s, %d, [%s]\n", 
                    s.getName(),s.getEmail(),s.getPassword(),s.getTel(),s.getPay(),s.getSubjects());
    }  
    }
    
    static void inputTeachers() {
        while(true) {  
            Teacher m  = new Teacher(); 
            
            System.out.print("이름을 입력하세요 :\t");
            m.setName(KeyIn.nextLine());
            
            System.out.print("이메일을 입력하세요 :\t ");
            m.setEmail(KeyIn.nextLine());
            
            System.out.print("암호를 입력하세요 :\t"); 
            m.setPassword(KeyIn.nextLine());
            
            System.out.print("전화번호를 입력하세요 :\t");
            m.setTel(KeyIn.nextLine());
            
            System.out.print("시급: \t ");
            m.setPay(Integer.parseInt(KeyIn.nextLine()));
            
            System.out.print("강의과목을 입력하세요 : \t");
            m.setSubjects(KeyIn.nextLine());
            
            teachers[teacherIndex++] = m;
            
            System.out.println("계속 하시겠습니까? (Y/n) ");
            
            String answer = KeyIn.nextLine();  
            
            if(answer.toLowerCase().equals("n")) 
                    break;
    }
}
    
}
