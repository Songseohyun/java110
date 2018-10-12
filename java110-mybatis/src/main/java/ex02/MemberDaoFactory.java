package ex02;

public class MemberDaoFactory  {
    
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MemberDao createMemberDao() throws Exception {
        
        // 객체를 생성해주는 메소드
        // => Factory Method 설계 패턴
        // => 객체 생성 과정이 복잡하거나 번거로울 경우 주로 사용한다.
        
        MemberDao memberDao = new MemberDao();
        memberDao.setDataSource(dataSource);
        
        return memberDao;
        
    }
}
