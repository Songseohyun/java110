// Client로 출력하기
// 한글 깨짐 현상 해결하기

package bitcamp.java110.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex03/servlet02")
public class Servlet02 extends GenericServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 출력스트림 객체를 꺼내기 전에 어떤 문자표를 사용하여 출력할 것인지 지정해야 한다.
        // 출력스트림 보다 먼저 문자셋을 설정해야만 한다.
        
        res.setContentType("text/pain;charset=UTF-8");
        
        // 서블릿 컨테이너는 이 설정에 따라 출력할 수 있는 출력 스트림 객체를 리턴한다.
        // 또한 응답할 때 Content-Type이라는 응답헤더를 추가한다.
        // 웹브라우저는 Content-Type 응답 헤더의 정보에 따라 웹 서버가 보낸 콘텐트를 처리한다.
        
        PrintWriter out = res.getWriter();
        out.println("Hello");
        out.println("안녕하세요");
        out.println("こんにちは ");
        out.println("你好");
        
        // Content-Type
        // => text/plain : MIME 타입
        // => charset=UTF-8 : 출력할 때 사용할 문자셋 지정
        // => Content-Type을 지정하지 않으면 기본으로 ISO-8859-1 문자표를 사용한다.
        //      Content-Type을 지정하면 응답할 때 응답헤더에 이 정보를 추가한다.
        //      웹브라우저는 응답헤더에 포함된 콘텐트 타입의 정보를 바탕으로
        //      콘텐트를 어떻게 처리할 지 결정한다.
        //      웹브라우저가 처리할 수 없는 MIME 타입인 경우 사용자에게 다운로드를 요구한다.
        
        
        //MIME(Milti-purpose Internet Mail Extensions)
        // => 메일에 첨부하는 파일의 타입을 지정하기 위해 만듬
        // => 메일 클라이언트는 이 타입 정보를 보고 첨부 파일을 읽을때
        // 어떤 프로그램을 사용해야 하는지 결정한다.
        // => 세월이 흘러 인터넷 분야에서 Content 타입을 지정할때 
        // 이 MIME 타입을 사용하게 되었다.
        // => 웹브라우저는 서버에서 받은 콘텐트르 어떻게 출력할것인지
        // 이 MIME 타입을 보고 결정한다.
        
        // Character-Set
        // => 컴퓨터에서 문자를 저장할 때 어떤 코드 값으로 저장할 것인지를 정의한 규칙이다.
        // => ex)ASCII - (7bit; 미국 표준)
        //          ISO-8859-1(ISO-Latin-1) 국제표준 8it
        //          EUC-KR 16bit 국제 표준이다 한글 2350자 정의
        //          조합형 16bit 아래아한글 규칙 초성(5bit) 중성(5bit) 종성(5bit)로 표현 국제표현X  3만자 이상의 모든 한글 문자를 표기할 수 있다.
        //          MS949(CP949) 16bit MS OS의 코드표 EUC-KR(2350) + 8822 = 11172 국제표현 X
        //          unicode 16bit 국제표준 한글은 11172자 정의
        //                                영어도 2바이트로 표현된다.
        //          UTF-8 1~4 바이트로 문자 표현 국제표전이다.
        //          유니코드의 변형이다. 한글은 규칙에 따라 3바이트로 표현한다.
        //          영어는 ISO-8859-1 코드 그대로 1바이트로 표현한다.
        
    }

}
