package com.kozlovnazarov.models;

public class UserModel {

    private String m_nickName;

    public UserModel(String nickName) {
        m_nickName = nickName;
    }

    public String getnickName(){
        return m_nickName;
    }
}
