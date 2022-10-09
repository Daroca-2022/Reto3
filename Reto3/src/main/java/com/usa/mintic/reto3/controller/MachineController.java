package com.usa.mintic.reto3.controller;

import com.example.demoo.model.Machine;
import com.example.demoo.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }

    @PostMapping("/save")
    public Machine save(@RequestBody Machine p){
        return machineService.save(p);
    }

}
