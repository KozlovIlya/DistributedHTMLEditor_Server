package com.kozlovnazarov.controllers;

import com.kozlovnazarov.classes.StringLine;
import com.kozlovnazarov.classes.User;

import java.util.List;
import java.util.Set;

public class DocumentController {

    private List m_textDocument;
    private List  m_userSet;

    private boolean m_textDocumentChanged;
    private boolean m_userListChanged;

    DocumentController() {
        // Получаем актуальное состояние документа с сервера
        // Инициализируем m_textDocument и m_userSet
    }

    public void refresh() {
        // Получаем актуальное состояние документа с сервера
        // Реинициализируем m_textDocument и m_userSet
        // Смотрим изменилось ли состояние документа/списка юзеров
    }

    public boolean textDocumentChanged() {
        // нужно ли?
        return m_textDocumentChanged;
    }

    public boolean userListChanged() {
        // нужно ли?
        return m_userListChanged;
    }

    public boolean blockLinesByUser(StringLine[] line, User user) {
        // Спрашиваем сервер "свободны" ли строки
        // "прикрепляем" пользователя к строкам
        return false; // возвращаем true если получилось, false - в противном случае
    }

    public boolean saveChangesOfUser(User user, StringLine[] newLines){
        // Сохраняем изменения на сервере
        return false; // возвращаем true если получилось, false - в противном случае
    }
}
