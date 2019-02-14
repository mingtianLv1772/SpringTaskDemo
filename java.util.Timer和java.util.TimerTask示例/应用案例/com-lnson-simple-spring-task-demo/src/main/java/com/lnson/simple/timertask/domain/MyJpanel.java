package com.lnson.simple.timertask.domain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MyJpanel extends JPanel implements Runnable{

    // 集合用来存储生成的雪花对象
    private List<XueHua> list = new ArrayList<>();
    private JFrame frame;
    // 读取到的雪花图片
    private BufferedImage image;
    // 设置背景图片
    private JLabel label = new JLabel();

    public MyJpanel(JFrame frame){
        this.frame = frame;
        try {
            // 读取雪花的图片
            image = ImageIO.read(MyJpanel.class.getClassLoader().getResource(MessageFormat.format("images/{0}","snow.png")));
            // 给面板设置背景图片
            ImageIcon icon = new ImageIcon(MyJpanel.class.getClassLoader().getResource(MessageFormat.format("images/{0}","bg1.png")));
            label.setIcon(icon);
            this.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 用来记录产生雪花的数量
    int sum = 0;

    /**
     * 在面板上画内容
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 从集合中获取到雪花，然后画在面板上
        for (int i = 0; i < list.size(); i++) {
            // 获取到雪花对象
            XueHua xueHua = list.get(i);
            // 让雪花产生动画效果
            xueHua.run();
            // 画在面板上
            g.drawImage(image,(int)xueHua.x,(int)xueHua.y,xueHua.w,xueHua.h,null);
        }

        // 设置字体颜色
        g.setColor(Color.PINK);
        // 设置字体
        g.setFont(new Font("隶书",Font.BOLD,20));

        // 当雪花数量大于30的时候，开始产生文字
        if(sum >= 30) {
            // 获取到标题内容
            String title = frame.getTitle();
            g.drawString(title, 40, 40);
        }
    }

    /**
     * 启动线程，生产更多的雪花
     */
    @Override
    public void run() {
        int num = 0;
        // 创建出雪花
        while (true){
            if(num > 10){
                new XueHua(frame,list);
                num=0;
                // 创建一个雪花，记录一个数量
                sum++;
            }
            num++;
            this.repaint();
            try {
                // 睡眠
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // 定义循环的长度
    int len = 0;

    /**
     * 切换背景图片
     */
    public void changebg(MyJpanel jpanel,String [] bgs) {
        // 读取雪花的图片
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String bg = bgs[len];
                // 给面板设置背景图片
                ImageIcon icon = new ImageIcon(MyJpanel.class.getClassLoader().getResource(MessageFormat.format("images/{0}",bg)));
                label.setIcon(icon);
                jpanel.add(label);
                len++;
                if(len == bgs.length){
                    len = 0;
                }
            }
        };
        Timer timer = new Timer();
        // 5秒后开始切换
        long delay = 0;
        // 每隔5秒执行一次
        long intevalPeriod = 5 * 1000;
        // 开启定时任务
        timer.schedule(timerTask,delay,intevalPeriod);
    }

}
