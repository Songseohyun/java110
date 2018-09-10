package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//어노테이션 유지 정책 
//class   :컴파일 한 후 .class 파일에 남겨둔다. 실행할 때는 참조할 수 없다.
//         Reflection API로 클래스 파일에서 어노테이션 정보를 추출 할 수 없다.
//         어노테이션 유지 정책을 지정하지 않으면 class 가 기본 값이다.
//source  :컴파일 할 때 제거된다. 즉 .class 파일에 남겨 두지 않는다.
//Runtime :컴파일 한 후에도 .class 파일에 남겨 둔다. 실행할 때도 참조할 수 있다.
//         Reflection API로 클래스에서 어노테이션 정보를 추출할 수 있다.

@Retention(RetentionPolicy.RUNTIME) 
public @interface Component {
    String value() default  "";
}
