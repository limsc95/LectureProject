package kr.bit.service;

import kr.bit.beans.Lecture;
import kr.bit.beans.User;
import kr.bit.dao.LectureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LectureDAO lectureDAO;


    public void lectureRegInsert(int register_lecture_idx){
        lectureDAO.lectureRegInsert(register_lecture_idx);
    }

    public void lectureRegDelete(int register_lecture_idx){
        lectureDAO.lectureRegDelete(register_lecture_idx);
    }


    public void lectureUserAdd(int lecture_idx){
        lectureDAO.lectureUserAdd(lecture_idx);
    }

    public void lectureUserMul(int lecture_idx){
        lectureDAO.lectureUserMul(lecture_idx);
    }

    public List<Lecture> lectureList(){
        return lectureDAO.lectureList();
    }

    public List<Lecture> myLectureList(){
        return lectureDAO.myLectureList();
    }
}
