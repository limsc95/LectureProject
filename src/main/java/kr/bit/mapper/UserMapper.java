package kr.bit.mapper;

import kr.bit.beans.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// 1. mapper 생성
// 2. ServletAppContext에 MapperFactoryBean 등록
// 3. userDAO 생성 및 mapper 호출
// 4. service 생성 및 dao 호출
// 5. controller 생성 및 service 호출
public interface UserMapper {

}
