package kr.bit.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    private int user_idx;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_id;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;

    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public @Size(min = 4, max = 10) @Pattern(regexp = "[a-zA-Z0-9]*") String getUser_id() {
        return user_id;
    }

    public void setUser_id(
            @Size(min = 4, max = 10) @Pattern(regexp = "[a-zA-Z0-9]*") String user_id) {
        this.user_id = user_id;
    }

    public @Size(min = 4, max = 10) @Pattern(regexp = "[a-zA-Z0-9]*") String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(
            @Size(min = 4, max = 10) @Pattern(regexp = "[a-zA-Z0-9]*") String user_pw) {
        this.user_pw = user_pw;
    }
}