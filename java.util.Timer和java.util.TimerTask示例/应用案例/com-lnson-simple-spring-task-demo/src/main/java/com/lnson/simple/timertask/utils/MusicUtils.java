package com.lnson.simple.timertask.utils;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MusicUtils {
    public MusicUtils() {
    }

    public static void play(String filepath) {
        try {
            File file = new File(filepath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream stream = new BufferedInputStream(fis);
            Player player = new Player(stream);
            player.play();
        } catch (Exception var5) {
            var5.printStackTrace();
            System.out.println("================播放音乐出现错误=================");
        }

    }

    public static void play(InputStream inputStream) {
        try {
            BufferedInputStream stream = new BufferedInputStream(inputStream);
            Player player = new Player(stream);
            player.play();
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("================播放音乐出现错误=================");
        }

    }
}
