package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import com.codecool.enterprise.overcomplicated.service.ServiceCaller;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
@SessionAttributes({"player", "game"})
@Data
public class GameController {

    @Autowired
    private ServiceCaller serviceCaller;

    @Autowired
    TictactoeGame tictactoeGame;

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame();
    }

    //@ModelAttribute("avatar_uri")
    //public URL getAvatarUri() throws MalformedURLException {
      //  URL avatar = serviceCaller.getAvatar();
        //return avatar;
    //}

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) throws IOException {
        model.addAttribute("funfact", serviceCaller.retrieveFunFact());
        model.addAttribute("comic_uri", serviceCaller.retrieveComic());
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        tictactoeGame.playerMove(move);
        tictactoeGame.checkIfWon('X');

        System.out.println("Player moved " + move);
        return "redirect:/game";
    }
}
