package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Canvas c = null;
        String input;
        System.out.println("Welcome to Drawing Program! \nFollowing are the commands and description available: \n" +
                "C w h         --> Create new canvas of width w and height h \n" +
                "L x1 y1 x2 y2 --> Create a new line from (x1,y1) to (x2,y2), currently only horizontal or vertical lines supported.\n" +
                "R x1 y1 x2 y2 --> Create a new rectangle from (x1,y1) to (x2,y2) \n" +
                "B x y c       --> Fill entire area connected to (x,y) with colour c \n" +
                "Q             --> Quit the program");

        do {
            // Reading from System.in
            Scanner reader = new Scanner(System.in);
            System.out.print("enter command: ");
            input = reader.next();
            if (input.equals("C")) {
                c = new Canvas();
                try {
                    int width = reader.nextInt();
                    int height = reader.nextInt();
                    c.setCanvasArray(width, height);
                    c.printCanvas();
                } catch (InputMismatchException e) {
                    System.out.println("Input Mismatch");
                } catch (OutOfMemoryError e){
                    System.out.println("Array size exceeds VM Limit");
                }
            }
            else if (input.equals("L")) {
                if (c != null) {
                    try{
                        int x1 = reader.nextInt();
                        int y1 = reader.nextInt();
                        int x2 = reader.nextInt();
                        int y2 = reader.nextInt();
                        c.createLine(x1,y1,x2,y2);
                        c.printCanvas();
                    }
                    catch(InputMismatchException e){
                        System.out.println ("Input Mismatch");
                    }
                }
                else{
                    System.out.println("Please initialise Canvas with command C [Width] [Height]");
                }
            } else if (input.equals("R")) {
                if (c != null) {
                    try{
                        int x1 = reader.nextInt();
                        int y1 = reader.nextInt();
                        int x2 = reader.nextInt();
                        int y2 = reader.nextInt();
                        c.createRectangle(x1,y1,x2,y2);
                        c.printCanvas();
                    }
                    catch(InputMismatchException e){
                        System.out.println ("Input Mismatch");
                    }
                }
                else{
                    System.out.println("Please initialise Canvas with command C [Width] [Height]");
                }
            } else if (input.equals("B")) {
                if (c != null) {
                    try{
                        int x = reader.nextInt();
                        int y = reader.nextInt();
                        char colour  = reader.next().charAt(0);
                        c.fillColourInitialise(x,y,colour);
                        c.printCanvas();
                    }
                    catch(InputMismatchException e){
                        System.out.println ("Input Mismatch");
                    }
                }
                else{
                    System.out.println("Please initialise Canvas with command C [Width] [Height]");
                }
            } else if (input.equals("Q")) {
                reader.close();
                return;
            } else {
                System.out.print("Input is not recognised. Please re-key");
            }
        }
        while (!(input.equals("Q")));

        return;
    }
}
