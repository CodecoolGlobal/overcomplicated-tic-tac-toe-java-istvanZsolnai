package com.codecool.enterprise.overcomplicated.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TictactoeGame {

    private char[] board = {'-','-','-',
                            '-','-','-',
                            '-','-','-',};

    public String getBoardString(){
        String boardString = new String(board);
        return boardString;
    }

    public void playerMove(int playerMove){
        if (board[playerMove] == '-'){
            this.board[playerMove] = 'X';
        }else {
            System.out.println("You cant place that there");
        }

    }
    public void aiMove(int aiMove){
        if (board[aiMove] == '-'){
            this.board[aiMove] = 'O';
        }
    }

    public boolean checkIfWon(char c){
        for (int i = 0; i < 2; i++) {
            if (board[3 * i] == c && board[3 * i + 1] == c && board[3 * i + 2] == c){
                System.out.println("===GAME WON===");
                System.out.println("===GAME WON===");
                return true;
            }
        }

        for (int i = 0; i < 2 ; i++) {
            if (board[i] == c && board[i + 3] == c && board[i + 6] == c)
                System.out.println("WON IN COLUMNS");
                return true;
        }

        if (board[0] == c && board[4] == c && board[8] == c ||
            board[2] == c && board[4] == c && board[8] == c){
            return true;
        }
        return false;
    }

    public String getEndgame(){
        String message;

        if (checkIfWon('X')){
            message = "Player won";
        }

        if (checkIfWon('O')){
            message = "AI won";
        }
        else {
            message = "It's a tie";
        }
        return message;
    }
}
