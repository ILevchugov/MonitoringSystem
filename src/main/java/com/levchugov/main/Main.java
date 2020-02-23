package com.levchugov.main;

import com.levchugov.emailsender.EmailSender;
import com.levchugov.emailsender.MessageCreator;
import com.levchugov.webpagesmatcher.WebPagesMatcher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> currentWebPages = new HashMap<>();
        HashMap<String, String> prevWebPages = new HashMap<>();
        /**
         * Здесь должен быть метод заполнения этих веб-страниц из какого-то источника
         * для теста заполноим произвольным содержанием
         */
        currentWebPages.put("vk.com", "smth html content");
        currentWebPages.put("google.com", "smth modified html content");
        prevWebPages.put("google.com", "smth html contnent");
        prevWebPages.put("fb.com", "smth html");
        prevWebPages.put("anya.com", "smth htnl ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите email секретаря");
        String emailAdress = scanner.nextLine();

        String name = "Aнна Ивановна"; //имя секретаря

        WebPagesMatcher wbm = new WebPagesMatcher(prevWebPages, currentWebPages);

        MessageCreator message = new MessageCreator();

        String text = message.getMessageAboutStatusWebPages(wbm.getRemovedPages(), wbm.getNewPages(), wbm.getModifiedPages(), name );

        try {
            EmailSender Sender = new EmailSender("levchugovfortests@gmail.com", "Testtest05");
            Sender.send("Изменения Веб сайтов", text, emailAdress);
        } catch (Exception e){
            System.out.println("Отправка сообщения невозможна");
            System.out.println(e);
        }



    }
}
