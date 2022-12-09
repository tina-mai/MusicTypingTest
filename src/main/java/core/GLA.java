package core;

import genius.SongSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class GLA {

    private HttpManager httpManager = new HttpManager();

    public SongSearch search(String query) throws IOException {
        return new SongSearch(this, query);
    }

    public HttpManager getHttpManager() {
        return this.httpManager;
    }

    public static void main(String[] args) throws Exception {
        GLA gla = new GLA();
        //Scanner s = new Scanner;
        System.out.println("Searching...");
        long startMs = System.currentTimeMillis();

        String lyrics = gla.search("Kygo").getHits().get(0).fetchLyrics();
        String[] words = lyrics.split(" ");
        System.out.println(words[6]);


    }

}
