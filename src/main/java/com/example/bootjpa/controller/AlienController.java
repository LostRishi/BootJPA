package com.example.bootjpa.controller;

import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo; // it is an interface

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

//    @RequestMapping("/addAlien")
//    public String addAlien(alien alien){
//        repo.save(alien);
//        return "home.jsp";
//    }

//    @RequestMapping("/getAlien")@
//    public ModelAndView getAlien(@RequestParam int aid){
//        ModelAndView mv = new ModelAndView("showAlien.jsp");
//        alien aln = repo.findById(aid).orElse(new alien());
//        System.out.println(repo.findByTech("Flutter"));    //findBytEch is not present in crudRepo
//        System.out.println(repo.findByAidGreaterThan(102));
//        mv.addObject(aln);
//        return mv;
//    }

    @GetMapping(path = "/aliens")
    public List<Alien> getAliens(){
        return repo.findAll();
    }

    @RequestMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }

    //post request
    @PostMapping("/alien")
    public Alien addAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    //put request
    @PutMapping("/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    //delete request
    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid){
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }
}
