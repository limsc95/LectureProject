package kr.bit.mapper;

import kr.bit.beans.Lecture;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LectureMapper {

    //@Options(useGeneratedKeys = true,keyProperty = "register_idx")
    @Insert("insert into lecture_register (register_lecture_idx) values (#{register_lecture_idx})")
    void lectureRegInsert(int register_lecture_idx);

    @Delete("delete from lecture_register where register_lecture_idx=#{register_lecture_idx}")
    void lectureRegDelete(int register_lecture_idx);

    @Update("update lecture set lecture_user_num=lecture_user_num+1 where lecture_idx=#{lecture_idx}")
    void lectureUserAdd(int lecture_idx);

    @Update("update lecture set lecture_user_num=lecture_user_num-1 where lecture_idx=#{lecture_idx}")
    void lectureUserMul(int lecture_idx);

    @Select("select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is null")
    List<Lecture> lectureList();

    @Select("select l.* from lecture l left join lecture_register r on l.lecture_idx=r.register_lecture_idx where r.register_lecture_idx is not null")
    List<Lecture> myLectureList();
}
