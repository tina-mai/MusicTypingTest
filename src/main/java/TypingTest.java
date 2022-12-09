import processing.core.PApplet;

public class TypingTest extends PApplet {

    Scanner s;
    ArrayList<String> words;

    public static void main(String[] args) { PApplet.main("TypingTest"); }

    public void settings() { size(750, 500); }

    public void setup() {


    }

    public void draw() {
        textSize(30);
        text("MUSIC TYPING TEST", 250, 50);
        text("Type in the artist you want in terminal", 200, 150);

        // process what they user types in

        if (keyPressed) {
            if (key == ENTER || key == RETURN) {

                fill(0, 0, 0);
                text("lyric lyric lyric", 200, 300);
            }
        }

    }

    public void keyPressed() {
//        stroke(255, 255, 255);
//        rect(0, 100, 750, 300);
//        fill(255, 255, 255);

    }

}
