package lessons.Lesson5;

import java.lang.reflect.Array;



public class Main {


    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size/2 ;
        float[] arr = new float[size];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        //включаю отсчет времени
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("первый способ  " + (System.currentTimeMillis() - a));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        //включаю отсчет времени
        long b = System.currentTimeMillis();
        float[] arr2 = new float[h];
        float[] arr3 = new float[h];
        System.arraycopy(arr, 0, arr2,0, h);
        System.arraycopy(arr, h, arr3,0, h);

        //первый поток
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        //второй поток
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr3.length; i++) {
                    arr3[i] = (float)(arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t.start();
        t2.start();
        try {
            t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr2, 0, arr, 0, h);
        System.arraycopy(arr3,0,arr, h,h);

        System.out.println("второй способ (два потока)  " + (System.currentTimeMillis() - b));

    }

}


