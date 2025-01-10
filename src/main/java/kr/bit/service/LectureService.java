package kr.bit.service;

import kr.bit.beans.Lecture;
import kr.bit.beans.User;
import kr.bit.dao.LectureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LectureDAO lectureDAO;

    @Resource(name="loginBean")
    private User loginUser;


    public void addLectureRegister(int register_lecture_idx){
        int register_user_idx = loginUser.getUser_idx();
        lectureDAO.addLectureRegister(register_user_idx, register_lecture_idx);
    }


    public void updateLecture(int lecture_idx){
        lectureDAO.updateLecture(lecture_idx);
    }

    public void deleteLecture(int register_lecture_idx){
        lectureDAO.deleteLecture(register_lecture_idx);
    }

    public List<Lecture> getUnLecture(){
        return lectureDAO.getUnLecture();
    }

    public List<Lecture> getLecture(){
        return lectureDAO.getLecture();

    }



}
