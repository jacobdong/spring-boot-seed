package site.igeek.model.po.entity;

import com.google.gson.annotations.Expose;
import site.igeek.config.Exclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jacobdong on 16/5/5.
 */
@Entity
public class User implements Serializable {
    @Id
    private String id;
    private String account;
    @Expose
    @Exclude(serialize = false)
    private String password;
    private Date createTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
