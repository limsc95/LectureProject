package kr.bit.dao;

import kr.bit.beans.Lecture;
import kr.bit.mapper.LectureMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureDAO {

    @Autowired
    private LectureMapper lectureMapper;

    public void lectureRegInsert(int register_lecture_idx){
        lectureMapper.lectureRegInsert(register_lecture_idx);
    }

    public void lectureRegDelete(int register_lecture_idx){
        lectureMapper.lectureRegDelete(register_lecture_idx);
    }


    public void lectureUserAdd(int lecture_idx){
        lectureMapper.lectureUserAdd(lecture_idx);
    }

    public void lectureUserMul(int lecture_idx){
        lectureMapper.lectureUserMul(lecture_idx);
    }

    public List<Lecture> lectureList(){
        return lectureMapper.lectureList();
    }

    public List<Lecture> myLectureList(){
        return lectureMapper.myLectureList();
    }
}
