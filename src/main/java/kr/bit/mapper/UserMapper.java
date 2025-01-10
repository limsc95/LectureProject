package kr.bit.mapper;

import kr.bit.beans.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

// 1. mapper 생성
// 2. ServletAppContext에 MapperFactoryBean 등록
// 3. userDAO 생성 및 mapper 호출
// 4. service 생성 및 dao 호출
// 5. controller 생성 및 service 호출
public interface UserMapper {
    // 로그인 처리 쿼리
    @Select("select user_idx, user_id, user_pw from lecture_user where user_id=#{user_id} and user_pw=#{user_pw}")
    User findUserByIdAndPw(@Param("user_id") String user_id, @Param("user_pw") String user_pw);

}
