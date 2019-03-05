package com.kozlovnazarov.models;


import java.io.IOException;

public class StringLineModel {

    private String m_content;
    private String m_reserverNickName;

    StringLineModel(String content, String reserverNickName) {
        m_content = content;
        m_reserverNickName = reserverNickName;
    }

    public void setReserverNickName(String reserverNickName) {
        m_reserverNickName = reserverNickName;
    }

    public String getReserverNickName() {
        return m_reserverNickName;
    }

    public void setContent(String content) {
        m_content = content;
    }

    public String getContent() {
        return m_content;
    }

}
