package com.example.casestudy_springmvc.Controller;

import com.example.casestudy_springmvc.Model.Game;
import com.example.casestudy_springmvc.Service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/games")
public class GameController {
    @Autowired
    private IGameService gameService;
    @GetMapping()
    public ModelAndView showGames(){
        Iterable<Game> gameList = gameService.findAll();
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("games", gameList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("game", new Game());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("game") Game game){
        gameService.save(game);
        return "redirect:/games";
    }
    @GetMapping("/{id}/update")
    public ModelAndView showUpdateForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/update");
        Game game = gameService.findById(id).get();
        modelAndView.addObject("game", game);

        return modelAndView;
    }
    @PostMapping("/update")
    public String update(Game game){
        gameService.save(game);
        return "redirect:/games";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        Game game = gameService.findById(id).get();
        modelAndView.addObject("game", game);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String delete(Game game){
        gameService.deleteById(game.getId());
        return "redirect:/games";
    }
}
