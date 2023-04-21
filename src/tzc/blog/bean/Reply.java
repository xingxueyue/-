package tzc.blog.bean;

import java.util.Date;

public class Reply {
    private int id;
    private String content;
    private String username;
    private int mobile;
    private Date creat_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Date getCreat_at() {
        return creat_at;
    }

    public void setCreat_at(Date creat_at) {
        this.creat_at = creat_at;
    }
}
