
package ex07;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
    public static void main(String[] args) throws Exception{
        String resource = "ex07/mybatis-config.xml";
        
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        Board board = boardDao.findByNo(1);
        System.out.printf("번호:%d\n", board.getNo());
        System.out.printf("제목:%s\n", board.getTitle());
        System.out.printf("내용:%s\n", board.getContent());
        System.out.printf("조회수:%d\n", board.getViewCount());
        System.out.printf("등록일:%s\n", board.getCreatedDate());
        
        // 게시물 상세조회의 작성자 정보처럼
        // 조인한 테이블의 다수의 데이터를 가져와야 할 경우,
        // Board 객체에 담지 말고 별도로 Member 객체를 만들어 담는 것이 
        // 유지보수에 좋다.
        // => 물론 개발자가 Member 객체를 만드는 것이 아니라,
        //      Mybatis가 Member 객체를 만들어 작성자 정보를 저장해 줄 것이다.
        // => 방법은?
        //      BoardDao-01.xml 
        
        System.out.printf("작성자 이름:%s\n", board.member.getName());
        System.out.printf("작성자 이메일:%s\n", board.member.getEmail());
        System.out.printf("작성자 전화 :%s\n", board.member.getTel());

    }

}
