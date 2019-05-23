package com.codecool.enterprise.overcomplicated.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TictactoeGame {

    private  String[] firstRow = new String[3];
    private  String[] secondRow = new String[3];
    private  String[] thirdRow = new String[3];

    public String putSign(String move){
        if (move.equals("0")){
            firstRow[0] = "X";
            return firstRow[0];
        }else if (move.equals("1")){
            firstRow[1] = "X";
            return firstRow[1];
        }else if (move.equals("2")){
            firstRow[2] = "X";
            return firstRow[2];
        }else if (move.equals("3")){
            secondRow[0] = "X";
            return secondRow[0];
        }else if (move.equals("4")){
            secondRow[1] = "X";
            return secondRow[1];
        }else if (move.equals("5")){
            secondRow[2] = "X";
            return secondRow[2];
        }else if (move.equals("6")){
            thirdRow[0] = "X";
            return thirdRow[0];
        }else if (move.equals("7")){
            thirdRow[1] = "X";
            return thirdRow[1];
        }else if (move.equals("8")){
            thirdRow[2] = "X";
            return thirdRow[2];
        }else
            return null;

    }

    public void betterIsGameWon(){
        for (String spot:firstRow
             ) {

        }
    }

    public boolean isGameWon(){
        if ( "X".equals(firstRow[0]) && "X".equals(firstRow[1]) && "X".equals(firstRow[2]) ||
             "X".equals(secondRow[0]) && "X".equals(secondRow[1]) && "X".equals(secondRow[2])||
             "X".equals(thirdRow[0]) && "X".equals(thirdRow[1]) && "X".equals(thirdRow[2]) ||
             "X".equals(firstRow[0]) && "X".equals(secondRow[1]) && "X".equals(thirdRow[2]) ||
             "X".equals(firstRow[2]) && "X".equals(secondRow[1]) && "X".equals(thirdRow[0]) ||
             "X".equals(firstRow[0]) && "X".equals(secondRow[0]) && "X".equals(thirdRow[0])||
             "X".equals(firstRow[1]) && "X".equals(secondRow[1]) && "X".equals(thirdRow[1])||
             "X".equals(firstRow[2]) && "X".equals(secondRow[2]) && "X".equals(thirdRow[2])


                /*firstRow[0].equals("X") && firstRow[1].equals("X") && firstRow[2].equals("X") /*||
            secondRow[0].equals("X") && secondRow[1].equals("X") && secondRow[2].equals("X") ||
            thirdRow[0].equals("X") && thirdRow[1].equals("X") && thirdRow[2].equals("X") ||
            firstRow[0].equals("X") || secondRow[1].equals("X") && thirdRow[2].equals("X")*/
        ) {
            System.out.println("GAME IS WON");
            System.out.println("GAME IS WON");
            System.out.println("GAME IS WON");
            System.out.println("GAME IS WON");
            emptyRow(firstRow);
            emptyRow(secondRow);
            emptyRow(thirdRow);
            return true;
        }
        System.out.println("Game is not yet won");
        return false;
    }

    public void emptyRow(String[] row){
        row[0] = "N";
        row[1] = "N";
        row[2] = "N";
    }


}
