package com.levchugov.emailsender;

import java.util.ArrayList;

public class MessageCreator {

    public String getMessageAboutStatusWebPages(ArrayList<String> removedPages, ArrayList<String> newPages, ArrayList<String> modifiedPages, String name){
        StringBuilder text = new StringBuilder();
        text.append("Здравствуйте, дорогая ")
                .append(name)
                .append("\n")
                .append("\n")
                .append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:")
                .append("\n")
                .append("\n")
                .append("Исчезли следующие страницы: ")
                .append(removedPages)
                .append("\n")
                .append("\n")
                .append("Появились следующие новые страницы: ")
                .append(newPages)
                .append("\n")
                .append("\n")
                .append("Изменились следующие страницы: ")
                .append(modifiedPages)
                .append("\n")
                .append("\n")
                .append("С уважением,")
                .append("\n")
                .append("автоматизированная система")
                .append("\n")
                .append("мониторинга.");

        return text.toString();
    }
}
