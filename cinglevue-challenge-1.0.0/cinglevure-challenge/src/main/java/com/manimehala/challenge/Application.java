package com.manimehala.challenge;

public class Application {
    public static void main(String[] args) {
        new WebPageSearchUtility().assertNumberOfHits(args[0], Integer.parseInt(args[1]));
    }
}