package com.common.weikaiyun.demo.model.network.bean;

import java.util.List;

public class User {
    private boolean admin;
    private List<Object> chapterTops;
    private List<Object> collectIds;
    private String email;
    private String icon;
    private int id;
    private String nickname;
    private String password;
    private String token;
    private int type;
    private String username;

    public boolean isAdmin() {
        return admin;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public List<Object> getCollectIds() {
        return collectIds;
    }

    public List<Object> getChapterTops() {
        return chapterTops;
    }

    public String getEmail() {
        return email;
    }

    public String getIcon() {
        return icon;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setChapterTops(List<Object> chapterTops) {
        this.chapterTops = chapterTops;
    }

    public void setCollectIds(List<Object> collectIds) {
        this.collectIds = collectIds;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
