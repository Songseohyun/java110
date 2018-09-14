package bitcamp.java110.cms.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {
    ApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;
    
    public ServerApp() throws Exception{
        createIoCContainer();
        processRequestMappingAnnotation();
        prepareRequestHandlerMap();
    }
    private void createIoCContainer() {
        
        iocContainer = 
                new ClassPathXmlApplicationContext
                ("bitcamp/java110/cms/conf/application-context.xml");
        
    }
    
    private void processRequestMappingAnnotation() {
        System.out.println("-----------------------------");
        String[] nameList = iocContainer.getBeanDefinitionNames();
        for(String name : nameList) {
            System.out.println(name);
        }
        System.out.println("-----------------------------");
        
    }
    private void prepareRequestHandlerMap() {
        requestHandlerMap = new RequestMappingHandlerMapping();
        // => IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);
            
            // => 객체에서 @RequestMapping이 붙은 메서드를 찾아 저장한다.
            requestHandlerMap.addMapping(obj);
        }
        
    }
    
    public void service() throws Exception {
        // 클라이언트 연결을 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("서버 실행 중...");
        try (
                // 서버에 연결하기
                Socket socket = serverSocket.accept();
                // 서버에 데이터를 보내고 읽을 도구를 준비한다.
                PrintStream out = new PrintStream(
                        new BufferedOutputStream(
                                socket.getOutputStream()));
                
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));) 
        {
            System.out.println(in.readLine());
            out.println("OK:Song"); out.flush();
            
            
            while(true) {
                String requestLine = in.readLine();
                if(requestLine.equalsIgnoreCase("exit")) {
                    out.println("goodbye"); 
                    out.println();
                    out.flush();
                    break; 
                }
                RequestMappingHandler mapping = requestHandlerMap.getMapping(requestLine);
                if (mapping == null) {
                    System.out.println("해당 요청을 처리할 수 없습니다.");
                    out.println();
                    out.flush();
                    continue;
                }
                
                try {
                    mapping.getMethod().invoke(mapping.getInstance(), out);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("요청 처리 중에 오류가 발생했습니다.");
                }
                out.println();
                out.flush();
            }
            
        }catch(Exception e) {
            
        }
    }
        
    public static void main(String[] args) throws Exception {
        ServerApp serverApp = new ServerApp();
        serverApp.service();
    }
}






















