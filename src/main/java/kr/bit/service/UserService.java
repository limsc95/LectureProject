package kr.bit.service;

import kr.bit.beans.User;
import kr.bit.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Resource(name = "loginBean")
    private User loginUser;

    public boolean login(String user_id, String user_pw) {
        User user =  userDAO.findUserByIdAndPw(user_id, user_pw);

        if (user == null) {
            return false;
        }

        loginUser.setLogin(true);
        loginUser.setUser_idx(1);
        return true;
    }
}
