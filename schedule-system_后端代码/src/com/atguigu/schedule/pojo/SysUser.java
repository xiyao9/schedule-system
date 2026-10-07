package com.atguigu.schedule.pojo;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data //@Getter Setter ToString EqualsAndHashCode
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;

//    public SysUser() {
//    }
//
//    public SysUser(Integer uid, String username, String userPwd) {
//        this.uid = uid;
//        this.username = username;
//        this.userPwd = userPwd;
//    }
//
//    public Integer getUid() {
//        return uid;
//    }
//
//    public void setUid(Integer uid) {
//        this.uid = uid;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getUserPwd() {
//        return userPwd;
//    }
//
//    public void setUserPwd(String userPwd) {
//        this.userPwd = userPwd;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        SysUser sysUser = (SysUser) o;
//        return Objects.equals(uid, sysUser.uid) && Objects.equals(username, sysUser.username) && Objects.equals(userPwd, sysUser.userPwd);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(uid, username, userPwd);
//    }
//
//    @Override
//    public String toString() {
//        return "SysUser{" +
//                "uid=" + uid +
//                ", username='" + username + '\'' +
//                ", userPwd='" + userPwd + '\'' +
//                '}';
//    }
}
