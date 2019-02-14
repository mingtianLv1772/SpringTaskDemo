package com.lnson.simple.timertask.main;

import com.lnson.simple.timertask.utils.MusicUtils;

public class MyMusic implements Runnable {
    public MyMusic() {
    }

    public void run() {
        MusicUtils.play(MyMusic.class.getClassLoader().getResourceAsStream("music/yq.mp3"));
    }
}
