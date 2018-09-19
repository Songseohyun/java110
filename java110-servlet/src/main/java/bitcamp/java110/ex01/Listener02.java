//리스너 만들기
// - 리스너(Listener)? 특정 상황에 놓이면 실행되는 객체
// - javax.servlet.XxxListener
package bitcamp.java110.ex01;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

// Client로부터 요청이 들어오면 실행되는 리스너
// Listener를 만들었으면 서블릿 컨테이너에 등록해야한다.

@WebListener
public class Listener02 implements ServletRequestListener{
    
    public Listener02() {
        System.out.println("Listener02() 호출됨.");
    }
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // Client 요청이 들어왔을 때 호출된다.
        // 예를 들면, 클라이언트의 IP 주소를 기록한다.
        System.out.println("Listener02.requestInitialized() 호출됨");
        HttpServletRequest httpRequest = (HttpServletRequest)sre.getServletRequest();
        System.out.printf("IP: %s\n", httpRequest.getRemoteAddr());
        System.out.printf("PATH: %s\n", httpRequest.getPathInfo());
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // Client에게 응답을 완료했을 때 호출된다.
        System.out.println("Listener02.requestDestroyed() 호출됨");
    }
}
