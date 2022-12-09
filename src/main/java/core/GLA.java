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
        System.out.println("Searching...");
        long startMs = System.currentTimeMillis();

        String lyrics = gla.search("Kygo").getHits().get(0).fetchLyrics();
        lyrics = lyrics.replaceAll("\n", " ");

        String[] unformatted = lyrics.split(" ");
        ArrayList<String> words = new ArrayList<>();

        System.out.println(lyrics);
        System.out.println("————————————");

        boolean gtg = true;

        for (int i=0; i < unformatted.length; i++) {

            String word = unformatted[i];
            if (word.contains("[")) {
                gtg = false;
            } else if (word.contains("]")) {
                gtg = true;
            } else if (gtg) {
                words.add(word);
            }
        }

        for (String w: words) {
            System.out.print(w + " ");
        }

    }

}
