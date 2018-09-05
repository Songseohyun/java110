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
    
    
    static Member[] members = new Member[100];
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
                printMembers();
            }else if(command.equalsIgnoreCase("add")) {
                inputMembers();
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
           System.out.println(menu);
           
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
    
        static void printMembers() {
            for(int i = 0; i < index; i++) {
                System.out.printf("%s, %s, %s\n", members[i].getName(), members[i].getEmail(), members[i].getPassword());
        }
}
        static void inputMembers() {
            while(true) {
                Member m  = new Member(); 
                
                System.out.print("이름을 입력하세요 :\t");
               m.setName(KeyIn.nextLine());
                
                System.out.print("이메일을 입력하세요 :\t ");
                m.setEmail(KeyIn.nextLine());
                
                System.out.print("암호를 입력하세요 :\t"); 
                m.setPassword(KeyIn.nextLine());
                
                members[index++] = m;
                
                System.out.println("계속 하시겠습니까? (Y/n) ");
                
                String answer = KeyIn.nextLine();  
                
                if(answer.toLowerCase().equals("n")) 
                        break;
        }
}
}
