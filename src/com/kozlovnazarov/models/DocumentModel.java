package com.kozlovnazarov.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentModel {

    private String m_uri = "src/com/kozlovnazarov/web/document.html";
    private List m_document;
    private List m_users;

    public DocumentModel() {
        m_document = new ArrayList<StringLineModel>();
        m_users = new ArrayList<String>();
        formDocument(m_uri);
    }

    public DocumentModel(String uri) {
        m_document = new ArrayList<StringLineModel>();
        m_users = new ArrayList<String>();
        formDocument(uri);
    }

    public void addStringLine(int id, String content, String reserverNickName) {
        try {
            if (!reserverNickName.contains(reserverNickName)) {
                return;
            }
        } catch (NullPointerException ex) {
        }
        StringLineModel stringLineModel = new StringLineModel(content, reserverNickName);
        m_document.add(id, stringLineModel);
        saveToFile();
    }

    public void addUser(String nickName) {
        if (!(m_users.contains(nickName) || nickName.equals(""))) {
            m_users.add(nickName);
        }
    }

    public void removeUser(String userNickName) {
        for (Object stringLineModel : m_document) {
            if (userNickName.equals(((StringLineModel) stringLineModel).getReserverNickName())){
                ((StringLineModel) stringLineModel).setReserverNickName(null);
            }
        }
        m_users.remove(userNickName);
    }

    public void removeLine(int id) {
        m_document.remove(id);
        saveToFile();
    }

    public String lineReserverNickName(int id) {
        return ((StringLineModel) m_document.get(id)).getReserverNickName();
    }

    public void setLineReserver(int id, String reserverNickName) {
        if (!m_users.contains(reserverNickName)) {
            return;
        }
        ((StringLineModel) m_document.get(id)).setReserverNickName(reserverNickName);
    }

    public List<Integer> getLinesReservedBy(String reserverNickName) {
        List idList = new ArrayList<Integer>();
        int idx = 0;
        for (Object stringLineModel : m_document) {
            if (((StringLineModel) stringLineModel).getReserverNickName() == reserverNickName) {
                idList.add((Integer)idx);
            }
            idx++;
        }
        return idList;
    }

    @Override
    public String toString() {
        String outString = "";
        for (Object stringLineModel : m_document) {
            outString = outString.concat(((StringLineModel) stringLineModel).getContent() + "\n");
        }
        return outString;
    }

    private void formDocument(String uri) {
        m_uri = uri;
        Path htmlDocPath = Paths.get(m_uri);
        Charset charset = Charset.forName("UTF-8");
        try {
            List<String> lines = Files.readAllLines(htmlDocPath, charset);
            for (String line : lines) {
                StringLineModel stringLineModel = new StringLineModel(line, null);
                m_document.add(stringLineModel);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveToFile() {
        String outString = "";
        for (Object stringLineModel : m_document) {
            outString = outString.concat(((StringLineModel) stringLineModel).getContent() + "\n");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(m_uri));
            writer.write(outString);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
