import processing.core.PApplet;

public class TypingTest extends PApplet {

    public static void main(String[] args) { PApplet.main("TypingTest"); }

    public void settings() { size(750, 500); }

    public void setup() {


    }

    public void draw() {
        textSize(30);
        text("MUSIC TYPING TEST", 250, 50);
        text("Press ENTER to continue...", 200, 150);

        if (keyPressed) {
            if (key == ENTER || key == RETURN) {

                fill(0, 0, 0);
                text("lyric lyric lyric", 200, 300);
            }
        }

    }

    public void keyPressed() {
        stroke(255, 255, 255);
        rect(0, 100, 750, 300);
        fill(255, 255, 255);

    }

}
