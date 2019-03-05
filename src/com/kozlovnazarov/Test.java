package com.kozlovnazarov;

import com.kozlovnazarov.models.DocumentModel;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static String defaultDoc = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Test</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    public static void main(String[] args) {

        // TEST CASE : PRINTING DOC
        DocumentModel model = new DocumentModel("src/com/kozlovnazarov/web/test.html");
        String str = model.toString();
        System.out.println(str);

        // TEST CASE : ADD LINE
        model.addStringLine(0, "<!-- Write your comments here -->", null);
        str = model.toString();
        System.out.println(str);

        // TEST CASE : REMOVE LINE
        model.removeLine(0);
        str = model.toString();
        System.out.println(str);

        // TEST CASE : GET RESERVER
        str = model.lineReserverNickName(0);
        System.out.println(str);

        // TEST CASE : GET RESERVER
        model.addUser("initUser");
        model.setLineReserver(0,"initUser");
        str = model.lineReserverNickName(0);
        System.out.println(str);

        // TEST CASE : GET RESERVED STRING
        model.setLineReserver(0,"initUser");
        model.setLineReserver(1,"initUser");
        model.setLineReserver(2,"initUser");
        List list = model.getLinesReservedBy("initUser");
        System.out.println(list.toString());

        //TEST CASE : REMOVE USER
        model.removeUser("initUser");
        str = model.lineReserverNickName(0);
        System.out.println(str);
    }
}
