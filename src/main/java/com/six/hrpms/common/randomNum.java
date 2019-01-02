package com.six.hrpms.common;

import java.util.Random;

public class randomNum {

    public static String getRandomNum(){
        String sources = "0123456789";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for(int i = 0;i<6 ;i++)
        {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return flag.toString();
    }
}
