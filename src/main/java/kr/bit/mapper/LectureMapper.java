package kr.bit.mapper;

import kr.bit.beans.Lecture;
import kr.bit.beans.LectureRegister;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 1. mapper 생성
// 2. ServletAppContext에 MapperFactoryBean 등록
// 3. userDAO 생성 및 mapper 호출
// 4. service 생성 및 dao 호출
// 5. controller 생성 및 service 호출
public interface LectureMapper {


    @Options(useGeneratedKeys = true, keyProperty = "lecture_idx")
    //   강의 목록 신청 버튼 맵핑 (1번 유저가 1번 강의 신청 클릭)
    @Insert("insert into lecture_register (register_user_idx,register_lecture_idx) values ( #{register_user_idx},#{register_lecture_idx})")
    void addLectureRegister(int register_user_idx, int register_lecture_idx);

    @Update("update lecture set lecture_user_num=lecture_user_num+lecture_idx = #{lecture_idx}")
    void updateLecture(int register_lecture_idx);


    //    내 강의 목록 취소 맵핑 (과목 번호 기준)
    @Delete("delete from lecture_register where register_lecture_idx=#{register_lecture_idx}")
    void deleteLecture(int register_lecture_idx);


    //강의 목록
    @Select("select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is null")
    List<Lecture> getUnLecture();

    //내 강의 목록
    @Select("select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is not null")
    List<Lecture> getLecture();








}
