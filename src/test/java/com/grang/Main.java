package com.grang;

public class Main {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.println("osName = " + osName);
        boolean mac = osName.contains("Mac");
        System.out.println("mac = " + mac);
    }
}
