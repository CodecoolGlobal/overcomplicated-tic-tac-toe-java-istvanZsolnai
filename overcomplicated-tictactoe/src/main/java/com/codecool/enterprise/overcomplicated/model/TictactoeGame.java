package com.codecool.enterprise.overcomplicated.model;

import com.codecool.enterprise.overcomplicated.controller.GameController;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

@Component
@Data
public class TictactoeGame {

    private String[] firstRow = new String[3];
    private String[] secondRow = new String[3];
    private String[] thirdRow = new String[3];

    public void putSign(String move){
        if (move.equals("0")){
            firstRow[0] = "X";
            System.out.println("gucci");
        }else if (move.equals("1")){
            firstRow[1] = "X";
            System.out.println("gucci");
        }else if (move.equals("2")){
            firstRow[2] = "X";
            System.out.println("gucci");
        }else if (move.equals("3")){
            secondRow[0] = "X";
            System.out.println("gucci");
        }else if (move.equals("4")){
            secondRow[1] = "X";
            System.out.println("gucci");
        }else if (move.equals("5")){
            secondRow[2] = "X";
        }else if (move.equals("6")){
            thirdRow[0] = "X";
        }else if (move.equals("7")){
            thirdRow[1] = "X";
        }else if (move.equals("8")){
            thirdRow[2] = "X";
        }

    }


}
