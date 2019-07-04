package com.plexus.appication;

import com.plexus.glass.GlassStack;

import java.util.Scanner;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer inp = getInput(scanner, "Enter the no of rows:");
        GlassStack glassStack = new GlassStack(Integer.parseInt(inp.toString()), 250);
        inp = getInput(scanner, "Enter the volume to be filled in litres:");
        glassStack.fillLiquid((int)(Double.parseDouble(inp.toString())*1000));
        inp = getInput(scanner, "Enter the row and column of the glass to find the volume (comma seperated):");
        int [] coordinates = Stream.of(inp.toString()
                .split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(glassStack.getGlassFilledVolume(coordinates[0], coordinates[1]));
    }

    private static StringBuffer getInput(Scanner scanner, String prompt) {
        StringBuffer inp = new StringBuffer();
        System.out.println(prompt);
        if(scanner.hasNext()){
            inp = new StringBuffer(scanner.nextLine());
        }
        return inp;
    }
}
