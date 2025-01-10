package kr.bit.dao;

import kr.bit.beans.Lecture;
import kr.bit.beans.LectureRegister;
import kr.bit.mapper.LectureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureDAO {

    @Autowired
    private LectureMapper lectureMapper;

    public void addLectureRegister(int register_user_idx, int register_lecture_idx){
        lectureMapper.addLectureRegister(register_user_idx, register_lecture_idx);
    }

    public void updateLecture(int lecture_idx){
        lectureMapper.updateLecture(lecture_idx);
    }

    public void deleteLecture(int lecture_idx){
        lectureMapper.deleteLecture(lecture_idx);
    }

    public List<Lecture> getUnLecture(){
        return lectureMapper.getUnLecture();
    }

    public List<Lecture> getLecture(){
        return lectureMapper.getLecture();

    }



}
