package com.levchugov.webpagesmatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class WebPagesMatcher {
    private HashMap<String, String> previousPages;
    private HashMap<String, String> currentPages;

    public WebPagesMatcher(){
        currentPages = new HashMap<>();
        previousPages = new HashMap<>();
    }

    public WebPagesMatcher(HashMap<String, String> previousPages, HashMap<String, String> currentPages ) {
        this.previousPages = previousPages;
        this.currentPages = currentPages;
    }

    public ArrayList getRemovedPages(){
        ArrayList<String> urlRemovedPages = new ArrayList();
        Set<String> prevURLs = previousPages.keySet();
        Set<String> currentURLs = currentPages.keySet();
        for (String URL : prevURLs) {
            if (!currentURLs.contains(URL))
                urlRemovedPages.add(URL);
        }
        return urlRemovedPages;
    }

    public ArrayList getNewPages(){
        ArrayList<String> urlNewPages = new ArrayList<>();
        Set<String> prevURLs = previousPages.keySet();
        Set<String> currentURLs = currentPages.keySet();
        for (String URL : currentURLs) {
            if (!prevURLs.contains(URL))
                urlNewPages.add(URL);
        }
        return urlNewPages;
    }

    public ArrayList getModifiedPages(){
        ArrayList<String> urlModifiedPages = new ArrayList<>();
        Set<String> prevURLs = previousPages.keySet();
        ArrayList<String> urlRemovedPages = this.getRemovedPages();
        for (String URL : prevURLs){
            String previousHTML = previousPages.get(URL);
            String currentHTML = currentPages.get(URL);
            if (!previousHTML.equals(currentHTML) && !urlRemovedPages.contains(URL))
                urlModifiedPages.add(URL);
        }
        return urlModifiedPages;
    }

}