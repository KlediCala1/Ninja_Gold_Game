package com.dojo.ninja_gold_game.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class NinjaGoldGame {
    @RequestMapping("/")
    public String index(HttpSession session) {
        if(session.getAttribute("gold") == null){
            session.setAttribute("gold", 0);
        }
        if(session.getAttribute("log") == null){
            session.setAttribute("log", new ArrayList<String>());
        }
        return "index.jsp";
    }
    @RequestMapping(value="/farm", method= RequestMethod.POST)
    public String farm(HttpSession session){
        int gold = (int) session.getAttribute("gold");
        int gain = (int) (Math.random() * 11 + 10);
        gold = gold + gain;
        session.setAttribute("gold", gold);

        ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
        log.add("You entered a farm and earned "+ gain + " gold. (" + new Date() +")" );
        session.setAttribute("log", log);

        return "redirect:/";
    }
    @RequestMapping(value="/cave", method= RequestMethod.POST)
    public String cave(HttpSession session){
        int gold = (int) session.getAttribute("gold");
        int gain = (int) (Math.random() * 6 + 5);
        gold = gold + gain;
        session.setAttribute("gold", gold);

        ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
        log.add("You entered a cave and earned "+ gain + " gold. (" + new Date() +")");
        session.setAttribute("log", log);

        return "redirect:/";
    }
    @RequestMapping(value="/house", method= RequestMethod.POST)
    public String house(HttpSession session){
        int gold = (int) session.getAttribute("gold");
        int gain = (int) (Math.random() * 4 + 2);
        gold = gold + gain;
        session.setAttribute("gold", gold);

        ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
        log.add("You entered a house and earned "+ gain + " gold. (" + new Date() +")");
        session.setAttribute("log", log);

        return "redirect:/";
    }
    @RequestMapping(value="/quest", method= RequestMethod.POST)
    public String quest(HttpSession session){
        int gold = (int) session.getAttribute("gold");
        int gain = (int) (Math.random() * 101 - 50);
        gold = gold + gain;
        session.setAttribute("gold", gold);

        ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
        if(gain > 0){
            log.add("You completed a quest and earned "+ gain + " gold. (" + new Date() +")");
        }else {
            log.add("You failed a quest and lost "+ -gain + " gold. Ouch. (" + new Date() +")");
        }

        session.setAttribute("log", log);

        return "redirect:/";
    }
}
