package kr.bit.beans;

public class Lecture {
    private int lecture_idx;
    private String lecture_subject;
    private String lecture_credit;
    private int lecture_user_num;
    private int lecture_max_num;
    private String lecture_day;
    private String lecture_time;

    public int getLecture_idx() {
        return lecture_idx;
    }

    public void setLecture_idx(int lecture_idx) {
        this.lecture_idx = lecture_idx;
    }

    public String getLecture_subject() {
        return lecture_subject;
    }

    public void setLecture_subject(String lecture_subject) {
        this.lecture_subject = lecture_subject;
    }

    public String getLecture_credit() {
        return lecture_credit;
    }

    public void setLecture_credit(String lecture_credit) {
        this.lecture_credit = lecture_credit;
    }

    public int getLecture_user_num() {
        return lecture_user_num;
    }

    public void setLecture_user_num(int lecture_user_num) {
        this.lecture_user_num = lecture_user_num;
    }

    public int getLecture_max_num() {
        return lecture_max_num;
    }

    public void setLecture_max_num(int lecture_max_num) {
        this.lecture_max_num = lecture_max_num;
    }

    public String getLecture_day() {
        return lecture_day;
    }

    public void setLecture_day(String lecture_day) {
        this.lecture_day = lecture_day;
    }

    public String getLecture_time() {
        return lecture_time;
    }

    public void setLecture_time(String lecture_time) {
        this.lecture_time = lecture_time;
    }
}
