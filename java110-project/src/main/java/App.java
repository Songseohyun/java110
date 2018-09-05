import java.util.Scanner;

public class App {
    
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
    static class Member{
        protected String name;
        protected String email;
        protected String password;
       
         //인스턴스의 메모리를 다루는 operator , setter/getter , accessor , property , message
        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
        
        @Override
        public String toString() {
            return "이름: "+name+",이메일: " +  email + ",비밀번호: "+password;
        }
    }
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
    
    static Student[] students = new Student[100];
    static int index = 0;
    
     static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) {
        
       
        while(true) {
        String menu = promptMenu();
        if(menu.equals("1")) {
            serviceStudentMenu();
        }else if(menu.equals("0")) {
            System.out.println("프로그램이 종료됩니다.");
            break;
        }
        }
        KeyIn.close();
          
          
    
    }

    private static void serviceStudentMenu() {
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

    private static String promptMenu() {
           System.out.println("[메뉴]");
           System.out.println("1. 학생 관리");
           System.out.println("2. 강사 관리");
           System.out.println("3. 매니저 관리");
           System.out.println("0. 닫기");
           
           while(true) {
           System.out.println("메뉴 번호 > ");
           
           String menu = KeyIn.nextLine();
           
           switch(menu) {
           case "0":
           case "1":
           case "2":
           case "3":
               return menu;
           default:
               System.out.println("메뉴 번호가 유효하지 않습니다.");
           }
        }
           
           
    }
    
        static void printStudents() {
            int count = 0;
            for(Student s : students) {
                if(count++ == index)
                    break;
                System.out.printf
                ("%s, %s, %s, %s, %b, %s\n", 
                        s.getName(),s.getEmail(),s.getPassword(),s.getSchool(),s.isWorking(),s.getTel());
        }  
}
        static void inputStudents() {
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
                
                students[index++] = m;
                
                System.out.println("계속 하시겠습니까? (Y/n) ");
                
                String answer = KeyIn.nextLine();  
                
                if(answer.toLowerCase().equals("n")) 
                        break;
        }
}
}
