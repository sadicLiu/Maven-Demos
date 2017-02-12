package com.liuhy.dependency;


import com.liuhy.quickstart.MavenFirst;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by liuhy on 2017/2/11.
 */
public class MavenSecond
{

    public static void main(String[] args)
    {
        MavenFirst first = new MavenFirst();
        String mashiyu = first.sayHello("mashiyu");
    }
}
