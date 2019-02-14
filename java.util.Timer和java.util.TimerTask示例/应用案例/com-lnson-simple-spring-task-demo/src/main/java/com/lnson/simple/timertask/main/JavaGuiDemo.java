package com.lnson.simple.timertask.main;

import com.lnson.simple.timertask.domain.MyJpanel;
import com.lnson.simple.timertask.utils.FrameUtils;

import javax.swing.*;

public class JavaGuiDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("TimerTask演示");
        FrameUtils.init(frame, 1000, 700);
        MyJpanel jpanel = new MyJpanel(frame);
        String[] bgs = new String[]{"bg1.png", "bg2.png", "bg3.png"};
        jpanel.changebg(jpanel, bgs);
        frame.add(jpanel);
        (new Thread(jpanel)).start();
        (new Thread(new MyMusic())).start();
        frame.setVisible(true);
    }

}
