package com.kozlovnazarov.classes;

public class StringLine {

    private String m_content = "";
    private int m_reserverId = 0;

    public  StringLine() { }

    public StringLine(String content, int reserverId) {
        m_content = content;
        m_reserverId = reserverId;
    }

    public void setContent(String content) {
        m_content = content;
    }

    public void setReserverId(int reserverId) {
        m_reserverId = reserverId;
    }

    public String getContent() {
        return m_content;
    }
}
