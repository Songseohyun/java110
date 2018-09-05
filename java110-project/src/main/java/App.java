import java.util.Scanner;

public class App {
    static Scanner KeyIn = new Scanner(System.in);
    public static void main(String[] args) {
        StudentController.KeyIn = KeyIn;
        TeacherController.KeyIn = KeyIn;
        ManagerController.KeyIn = KeyIn;
        while (true) {
            String menu = promptMenu();
            if (menu.equals("1")) {
                StudentController.serviceStudentMenu();
            } else if (menu.equals("2")) {
                TeacherController.serviceTeacherMenu();
            } else if(menu.equals("3")) {
                ManagerController.serviceManagerMenu();
            }else if (menu.equals("0")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
        }
        KeyIn.close();
    }
    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1. 학생 관리");
        System.out.println("2. 강사 관리");
        System.out.println("3. 매니저 관리");
        System.out.println("0. 닫기");
        while (true) {
            System.out.println("메뉴 번호 > ");
            String menu = KeyIn.nextLine();
            switch (menu) {
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
}
