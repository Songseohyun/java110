import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //1) 키보드 입력을 처리할 객체 준비
        Scanner KeyIn = new Scanner(System.in);
        //2) 사용자로부터 회원 정보 입력받기
        System.out.print("이름을 입력하세요 :\t");
        String name = KeyIn.nextLine(); //한줄입력받기 nextLine
        
        System.out.print("이메일을 입력하세요 :\t ");
        String email = KeyIn.nextLine();
        
        System.out.print("암호를 입력하세요 :\t");
        String pwd = KeyIn.nextLine();
        
        System.out.printf("%s, %s, %s\n", name, email, pwd);
    }
}
