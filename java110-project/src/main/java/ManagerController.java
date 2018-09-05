import java.util.Scanner;

public class ManagerController {
    
static Scanner KeyIn;
    static class Manager extends Member{
        protected String position;
        protected String tel;
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        
        
    }
    
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    
    static void serviceManagerMenu() {
        while(true) {
            System.out.println("매니저 관리 > 추가:add 목록:list 닫기:quit");
            String command = KeyIn.nextLine();
            if(command.equalsIgnoreCase("list")) {
                printManagers();
            }else if(command.equalsIgnoreCase("add")) {
                inputManagers();
            }else if(command.equalsIgnoreCase("quit")) {
                break;
            }
            else {
                System.out.println("유효하지 않는 명령어입니다.");
            }
        }
    }
    
    static void printManagers() {
        int count = 0;
        for(Manager s : managers) {
            if(count++ == managerIndex)
                break;
            System.out.printf
            ("%s, %s, %s, %s, %s\n", 
                    s.getName(),s.getEmail(),s.getPassword(),s.getPosition(),s.getTel());
    }  
    }
    
    static void inputManagers() {
        while(true) {  
            Manager m  = new Manager(); 
            
            System.out.print("이름을 입력하세요 :\t");
            m.setName(KeyIn.nextLine());
            
            System.out.print("이메일을 입력하세요 :\t ");
            m.setEmail(KeyIn.nextLine());
            
            System.out.print("암호를 입력하세요 :\t"); 
            m.setPassword(KeyIn.nextLine());
            
            System.out.print("직위를 입력하세요 :\t");
            m.setPosition(KeyIn.nextLine());
            
            System.out.print("전화번호를 입력하세요 : \t");
            m.setTel(KeyIn.nextLine());
            
            managers[managerIndex++] = m;
            
            System.out.println("계속 하시겠습니까? (Y/n) ");
            
            String answer = KeyIn.nextLine();  
            
            if(answer.toLowerCase().equals("n")) 
                    break;
    }
}
}
