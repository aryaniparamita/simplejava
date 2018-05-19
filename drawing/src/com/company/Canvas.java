package com.company;

/**
 * Created by Paramita on 31/3/2018.
 */
public class Canvas{
    int width, height;
    char [][] canvasArray;
    char lineCharacter = "x".charAt(0);
    char spaceCharacter = " ".charAt(0);
    char borderTopBottomCharacter = "-".charAt(0);
    char borderLeftRightCharacter = "|".charAt(0);

    public void setCanvasArray(int width, int height) {
        this.width = width+2;
        this.height = height+2;
        this.canvasArray = new char[this.height][this.width];
        //initialize all to "space" character at the start and border
        for (int i =0 ; i<this.height; i++){
            for (int j =0 ; j<this.width; j++){
                if ((i==0)||(i==this.height-1)){
                    canvasArray[i][j]= borderTopBottomCharacter;
                }
                else if((j==0)||(j==this.width-1)){
                    canvasArray[i][j] = borderLeftRightCharacter;
                }
                else {
                    canvasArray[i][j] = spaceCharacter;
                }
            }
        }
    }
    public void printCanvas(){
        for (int i = 0; i < (this.height); i++){
            for (int j = 0; j<this.width;j++){
                System.out.print(this.canvasArray[i][j]);
            }
            System.out.println();
        }
    }
    public char getContent(int y, int x){
        return canvasArray[y][x];
    }
    public void setContent (int y, int x, char c){
        canvasArray[y][x]= c;
    }




    public boolean createLine (int x1, int y1, int x2, int y2){
        int [] orderedPoint;
        //check if x1,y1,x2,y2 is in the boundary
        if (checkBoundary(x1,y1) && checkBoundary(x2,y2)) {
            //check if line is vertical
            if (x1 == x2) {
                orderedPoint = orderSmallToBig(y1,y2);
                for (int i= orderedPoint[0]; i<=orderedPoint[1]; i++) {
                    canvasArray[i][x1] = lineCharacter;
                }
                return true;
            }
            //check if line is horizontal
            else if (y1==y2) {
                orderedPoint = orderSmallToBig(x1,x2);
                for (int i= orderedPoint[0]; i<=orderedPoint[1]; i++) {
                    canvasArray[y1][i] = lineCharacter;
                }
                return true;
            }
            //if line is diagonal reject request
            else {
                //error invalid input
                System.out.println("Current system only support horizontal or vertical line");
                return false;
            }
        }
        else {
            //error out of boundary
            return false;
        }

    }
    public boolean createRectangle (int x1, int y1, int x2, int y2) {
        int [] orderedPointX, orderedPointY;
        if (checkBoundary(x1,y1) && checkBoundary(x2,y2)) {
            //determine smaller x coordinate
            orderedPointX = orderSmallToBig(x1,x2);
            orderedPointY = orderSmallToBig(y1,y2);

            //fill rectangle
            createLine(orderedPointX[0],orderedPointY[0],orderedPointX[0],orderedPointY[1]);
            createLine(orderedPointX[0],orderedPointY[1],orderedPointX[1],orderedPointY[1]);
            createLine(orderedPointX[1],orderedPointY[0],orderedPointX[1],orderedPointY[1]);
            createLine(orderedPointX[0],orderedPointY[0],orderedPointX[1],orderedPointY[0]);
            return true;
        }
        else {
            //error out of boundary
            return false;
        }

    }
    public boolean fillColourInitialise (int x, int y, char newCharacter) {
        if (checkBoundary(x,y)) {
            fillColour(x,y,newCharacter,getContent(y,x));
            return true;
        }
        else {
            return false;
        }
    }






    /////GENERAL UTILITIES///////////
    public void fillColour(int x, int y, char newCharacter, char oldCharacter){
        if (canvasArray[y][x]==oldCharacter) {
            //convert
            setContent(y,x, newCharacter);
            fillColour(x+1,y,newCharacter, oldCharacter);
            fillColour(x-1,y,newCharacter, oldCharacter);
            fillColour(x,y+1,newCharacter, oldCharacter);
            fillColour(x,y-1,newCharacter, oldCharacter);

        }
    }

    public boolean checkBoundary(int x1, int y1){
        if (!((x1>0) && (x1<this.width-1)  && (y1>0) && (y1<this.height-1))){
            System.out.println("Points given are outside boundary. Please re-submit");
            return false;
        }
        else {
            return true;
        }
    }
    public int[] orderSmallToBig (int number1, int number2) {
        int [] returnValue = new int[2];
        if (number1>number2) {
            returnValue[0]= number2;
            returnValue[1]= number1;
        }
        else {
            returnValue[0] = number1;
            returnValue[1] = number2;
        }
        return  returnValue;
    }

}


