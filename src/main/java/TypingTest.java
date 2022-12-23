import processing.core.PApplet;

public class TypingTest extends PApplet {

    Scanner s;

    ArrayList<String> words; // ArrayList of each word in the song
    int wordIndex; // the index of thewords on the screen (0-4)
    int letterIndex; // the index of the letter OF EACH WORD on the screen
    int k; // the index of the word in ArrayList words
    int progressSize; // the size for each progress bar progression
    int progress; // the total number of pixels that the progress bar has progressed
    TimerTask task;
    Timer timer;
    boolean end; // the game ends once timer reaches 1 minute

    // when the timer ends, boolean end is set to true
    class Helper extends TimerTask {
        public void run() {
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
        text("LYRIC TYPING TEST", 250, 50);

        int numChar; // number of characters on the screen (used to determine progressSize)

        // when the game ends, show user their speed
        if (end) {
            fill(255, 255, 255);
            stroke(255, 255, 255);
            rect(0, 0, 750, 500);

            fill(0, 0, 0);
            textSize(30);
            // shows the total number of words user has typed before time ran out
            text("Your speed is: " + (wordIndex + k - 4) + " words per minute", 100, 50); // subtract 4 because wordIndex starts at 0 and k is 5 ahead
        }
        // if game has not ended...
        else {
            // process what they user types in
            if (keyPressed) {
                int x_coord = 50;

                // when user types ENTER at the beginning of the game, the timer starts and 5 words are generated on the screen
                // this also generates 5 new words on the screen when a user finishes typing 5 words (wordIndex = 5)
                if (key == ENTER || key == RETURN || wordIndex == 5) {
                    if (wordIndex == 0){
                        System.out.println("Timer start");
                        timer.schedule(task, 60000 );
                    }

                    // reset all progress bar variables to 0
                    numChar = 0;
                    progress = 0;
                    progressSize = 0;

                    fill(255, 255, 255);
                    stroke(255, 255, 255);
                    rect(0, 0, 750, 500);

                    fill(0, 0, 0);

                    // get number of characters on the screen & print out the words (5 at a time)
                    for (int i=0; i<5; i++) {
                        fill(23,27,42);
                        numChar += words.get(i+k).length() + 1;
                        text(words.get(i+k),x_coord, 300);
                        x_coord += 50 + 15*(words.get(i+k).length());
                    }

                    // reset each set of 5 words
                    wordIndex = 0;
                    k += 5;
                    keyPressed = false;

                    // calculate how much the progress bar should progress (based on number of characters on the screen)
                    progressSize = width/numChar;
                }

                // this runs when you've reached the end a word (a.k.a. letterIndex = -1 (see below)); then you need to type in a space (since that's what comes after a word lol)
                if (letterIndex == -1 && key == ' ') {
                    letterIndex += 1;
                    System.out.print(" ");
                    progress += progressSize;
                    wordIndex += 1;
                }
                // checks if the letter you typed matches the current letter based on wordIndex and letterIndex
                // if it matches, update letterIndex, print out the current letter in terminal, and update progress bar
                else if (letterIndex != -1 && key == words.get(wordIndex+k-5).charAt(letterIndex)){
                    letterIndex += 1;
                    System.out.print(words.get(wordIndex + k - 5).charAt(letterIndex - 1));
                    progress += progressSize;
                }
                // checks if you have reached the end of a word (set letterIndex = -1 to indicate such)
                if (letterIndex == words.get(wordIndex+k-5).length()){
                    letterIndex = -1;
                    keyPressed = false;
                }
            }

            // progress bar
            fill(0, 255, 0);
            rect(0, 490, progress, 10); // progress determines the width of the bar
        }
    }

}
