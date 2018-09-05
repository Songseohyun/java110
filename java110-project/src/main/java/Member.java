
class Member{
    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
        protected String name;
        protected String email;
        protected String password;
       
         //인스턴스의 메모리를 다루는 operator , setter/getter , accessor , property , message
        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
        
        @Override
        public String toString() {
            return "이름: "+name+",이메일: " +  email + ",비밀번호: "+password;
        }
    }