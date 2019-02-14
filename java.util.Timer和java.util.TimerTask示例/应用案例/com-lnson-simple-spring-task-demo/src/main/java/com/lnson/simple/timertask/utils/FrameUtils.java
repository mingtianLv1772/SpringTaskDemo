package com.lnson.simple.timertask.utils;

import javax.swing.*;
import java.awt.*;

public class FrameUtils {
    public FrameUtils() {
    }

    public static void init(JFrame frame, int width, int height) {
        frame.setSize(width, height);
        frame.setLocationRelativeTo((Component)null);
        frame.setDefaultCloseOperation(3);
    }
}
