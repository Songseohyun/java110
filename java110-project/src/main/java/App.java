import java.util.Scanner;

public class App {
    static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] password = new String[100];
    static int index = 0;
    
    //1) 키보드 입력을 처리할 객체 준비
     static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) {
        
       inputMembers();
       printMembers();

        KeyIn.close(); 
    }
    
        static void printMembers() {
            for(int i = 0; i < index; i++) {
                System.out.printf("%s, %s, %s\n", names[i], emails[i], password[i]);
        }
        }
        static void inputMembers() {
          //2) 사용자로부터 회원 정보 입력받기
            while(true) {
                System.out.print("이름을 입력하세요 :\t");
               names[index] = KeyIn.nextLine(); //한줄입력받기 nextLine
                
                System.out.print("이메일을 입력하세요 :\t ");
                emails[index] = KeyIn.nextLine();
                
                System.out.print("암호를 입력하세요 :\t"); 
                password[index] = KeyIn.nextLine();
                
                index++;
                
                System.out.println("계속 하시겠습니까? (Y/n) ");
                
                String answer = KeyIn.nextLine();
                
                if(answer.toLowerCase().equals("n")) 
                        break;
        }
}
}
