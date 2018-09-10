import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer = new ApplicationContext("bitcamp.java110.cms.control");

        RequestMappingHandlerMapping requestHandlerMap = new RequestMappingHandlerMapping();

        // => IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitinNames();
        for (String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);
            // => 객체에서 @RequestMapping이 붙은 메소드를 찾아 저장한다.
            requestHandlerMap.addMapping(obj);
        }

        while (true) {
            String menu = prompt();
            if (menu.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            if (mapping == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
        }
        keyIn.close();
    }

/*    private static Method findRequestMapping(Class<?> clazz) {
        // => 클래스의 메소드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // => 메소드에서 @RequestMapping 정보를 추출한다.
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null)
                return m;// 찾았다면 이 메소드를 리턴한다.
        }
        return null;
    }*/

    private static String prompt() {
        System.out.println("[메뉴]");
        System.out.println("[학생관리]:student [매니저관리]:manager [강사관리]:teacher [끝내기]:exit");
        return keyIn.nextLine();
    }
}








