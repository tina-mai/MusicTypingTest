# LYRIC TYPING TEST

DIRECTIONS:
- Run TypingTest.java
- In the terminal, type in the artist/singer you want to type to. We'll find their most popular song (according to Genius) and display 5 words at a time on the screen
- Once the song has loaded, go to the processing window and press ENTER to start (timer will start once you press ENTER)
- Type until the timer reaches one minute (you'll be stopped once time runs out)
- Note: this is case-sensitive, spaces and punctuation matter, and you'll need to type a SPACE at the end of a line to move on
- If you make a mistake, check the terminal to see where you're at (don't worry about deleting your mistakes)

WARNING: There's no validation...
We recommend "Taylor Swift" for testing :)

[![](https://jitpack.io/v/LowLevelSubmarine/GeniusLyricsAPI.svg)](https://jitpack.io/#LowLevelSubmarine/GeniusLyricsAPI)

# About Genius Lyrics API (not-official)
This API is made to search and parse lyrics from the web. The Genius library should provide all the songs your users will ever search for. It uses genius's embed page to load lyrics without getting rate-limited, and caches every parsed lyrics and search results (runtime).

## Easy to use!
Just create a new *GLA* object and start with the *search(String)* method ;)

## Download

**Gradle**
```gradle
dependencies {
   implementation 'com.github.LowLevelSubmarine:GeniusLyricsAPI:1.0.3'
}

repositories {
    maven { url 'https://jitpack.io' }
}
```

**Maven**
```xml
<dependency>
    <groupId>com.github.LowLevelSubmarine</groupId>
    <artifactId>GeniusLyricsAPI</artifactId>
    <version>1.0.3</version>
</dependency>
```
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

# Disclaimer
This repository is for research purposes only, the use of this code is your responsibility.

I take NO responsibility and/or liability for how you choose to use any of the source code available here. By using any of the files available in this repository, you understand that you are AGREEING TO USE AT YOUR OWN RISK. Once again, ALL files available here are for EDUCATION and/or RESEARCH purposes ONLY.
