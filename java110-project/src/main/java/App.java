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
        
       inputMembers();
       printMembers();

        KeyIn.close(); 
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
