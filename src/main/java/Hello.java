package com.db.paas.fabric;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Created by padipes on 13/11/2017.
*/
public class Hello {

    public Hello() { }

    public static void main(String[] args) throws InterruptedException {
        Hello h = new Hello();
        for (int i=0; i<5; i++) {
            h.sayHello();
            System.out.println(getTime() + " - I shall repeat myself now...");
        }
    }

    public void sayHello() throws InterruptedException {

        InputStream in = getClass().getResourceAsStream("/speech.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String current;
        try  {
            while ( (current = reader.readLine()) != null) {
                System.out.println(getTime() + " - " + System.getenv("HOSTNAME") + " - " + current);
                Thread.sleep(5000);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTime() {
        long timeinMs = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss:SSS z");
        Date now = new Date(timeinMs);
        return sdf.format(now);
    }
}
