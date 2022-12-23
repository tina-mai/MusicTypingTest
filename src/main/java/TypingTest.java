import processing.core.PApplet;

public class TypingTest extends PApplet {

    Scanner s;
    ArrayList<String> words;
    int wordIndex;
    int letterIndex;
    int k;
    int progressSize; // the size for each progress bar progression
    int progress; // the total number of pixels that the progress bar has progressed
    TimerTask task;
    Timer timer;
    boolean end;

    class Helper extends TimerTask
    {
        public int i = 0;
        public void run()
        {
//            System.out.println("ONE MINUTEEE");
            end = true;
        }
    }

    public static void main(String[] args) { PApplet.main("TypingTest"); }

    public void settings() { size(750, 500); }

    public void setup() {


    }

    public void draw() {
        fill(0, 0, 0);
        textSize(30);
        text("MUSIC TYPING TEST", 250, 50);
        int numChar;
//        text("Type in the artist you want in terminal", 200, 150);

        if (end) {
            fill(255, 255, 255);
            stroke(255, 255, 255);
            rect(0, 0, 750, 500);

            fill(0, 0, 0);
            textSize(30);
            text("Your speed is: " + (wordIndex + k) + " words per minute", 100, 50);
        }

        // process what they user types in
        if (keyPressed) {
            int x_coord = 50;

            if (key == ENTER || key == RETURN || wordIndex == 5) {
                if (wordIndex == 0){
                    System.out.println("Timer start");
                    timer.schedule(task, 60000 );
                }

                numChar = 0;
                progress = 0;
                progressSize = 0;

                fill(255, 255, 255);
                stroke(255, 255, 255);
                rect(0, 0, 750, 500);

                fill(0, 0, 0);

                for (int i=0; i<5; i++) {
                    fill(23,27,42);
                    numChar += words.get(i+k).length() + 1;
//                    System.out.println(numChar);
                    text(words.get(i+k),x_coord, 300);
                    x_coord += 50 + 15*(words.get(i+k).length());
                }
                wordIndex = 0;
                k += 5;
                keyPressed = false;

                progressSize = width/numChar;
//                System.out.println("Progress bar size: " + progressSize);
            }
            if (letterIndex == -1 && key == ' ') {
                letterIndex += 1;
                System.out.print(" ");
                progress += progressSize;
                wordIndex += 1;
            }
            else if (letterIndex != -1 && key == words.get(wordIndex+k-5).charAt(letterIndex)){
                letterIndex += 1;
                System.out.print(words.get(wordIndex + k - 5).charAt(letterIndex - 1));
                progress += progressSize;
            }
//            else {
//                // they didn't type in the right letter
////                System.out.println("WRONG HAHA LOSER");
//                fill(255, 0, 0);
//                rect(0, 490, progress, 10);
//            }
            if (letterIndex == words.get(wordIndex+k-5).length()){
                letterIndex = -1;
//                wordIndex += 1;
                keyPressed = false;
            }
        }

        // progress bar
        if (!end) {
            fill(0, 255, 0);
            rect(0, 490, progress, 10);
        }
    }

}
