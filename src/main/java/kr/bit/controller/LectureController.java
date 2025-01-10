package kr.bit.controller;

import kr.bit.beans.Lecture;
import kr.bit.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

//    @Resource(name = "loginUser")
//    private User loginUser;

    @GetMapping("/lecture")
    public String lecture(Model model){

        List<Lecture> lectureList = lectureService.lectureList();
        List<Lecture> myLectureList = lectureService.myLectureList();
        model.addAttribute("lectureList",lectureList);
        model.addAttribute("myLectureList",myLectureList);

        return "lecture";
    }

    @PostMapping("/lecture_add")
    public String lecture_add(@RequestParam("lecture_index") int lecture_index){

        lectureService.lectureRegInsert(lecture_index);
        lectureService.lectureUserAdd(lecture_index);

        return "lecture_add";
    }

    @PostMapping("/lecture_mul")
    public String lecture_mul(@RequestParam("register_lecture_idx") int register_lecture_idx){

        lectureService.lectureRegDelete(register_lecture_idx);
        lectureService.lectureUserMul(register_lecture_idx);

        return "lecture_mul";
    }
}
