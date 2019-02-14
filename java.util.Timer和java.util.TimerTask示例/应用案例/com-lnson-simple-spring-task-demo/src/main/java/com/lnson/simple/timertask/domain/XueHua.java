package com.lnson.simple.timertask.domain;

import javax.swing.*;
import java.util.List;

/**
 * 雪花类
 */
public class XueHua {

    // 雪花的宽度和高度
    public int w,h;
    // 雪花产生的位置 x y 雪花每次移动的距离
    public float x,y,sdx,sdy;
    private List<XueHua> list;
    private JFrame frame;

    /**
     * 创建雪花对象，设置雪花在窗口中出现的位置，把雪花对象存入到list集合中。
     * @param frame
     * @param list
     */
    public XueHua(JFrame frame, List<XueHua> list){
        this.list = list;
        this.frame = frame;
        // 随机大小
        w=h=(int)(Math.random()*20+10);
        // x轴移动速度
        sdx=(float) (Math.random()*0.7+0.3);
        // y轴移动速度
        sdy=(float) (Math.random()*0.4+0.3);

        // 雪花出现的位置只能在屏幕的上右方
        double gailv=(double)(frame.getWidth()+frame.getHeight())/frame.getWidth()-1;
        // 雪花在屏幕上方
        if(Math.random()<gailv){
            y=-h;
            x=(int)(Math.random()*frame.getWidth());
        }else{
            // 雪花在屏幕右方
            x=frame.getWidth();
            y=(int)(Math.random()*frame.getHeight());
        }
        // 添加进集合
        this.list.add(this);
    }

    /**
     * 雪花每次移动的距离
     */
    public void run(){
        // 如果雪花超出屏幕范围的话就从集合中删掉
        if(x+w<0||y>this.frame.getHeight()||x+w<0||y>this.frame.getHeight()){
            this.list.remove(this);
        }
        y+=sdy;
        x-=sdx;
    }

}
