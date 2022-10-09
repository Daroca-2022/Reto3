package com.usa.mintic.reto3.controller;

<<<<<<< HEAD

import com.usa.mintic.reto3.model.Machine;
import com.usa.mintic.reto3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
//la base de las peticiones que se manejan x la ruta que se defina aqui y debe estar /api identifica backend
=======
import com.example.demoo.model.Machine;
import com.example.demoo.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
>>>>>>> nicolas
@RequestMapping("/api/Machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

<<<<<<< HEAD
    //respuesta a una peticion get
=======
>>>>>>> nicolas
    @GetMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }

<<<<<<< HEAD
    @GetMapping("/{id}")
    //el GetMapping le pasa a la funcion el dato a traves de @PathVariable
    public Optional<Machine> getById(@PathVariable("id") int machineId){
        return machineService.getById(machineId);
    }

    @PostMapping("/save")
    //Para el status 201 que pide Masterclass cuando se crea la peticion se ejecuta esta instruccion
    @ResponseStatus(HttpStatus.CREATED)
    //@ResquestBody tiene la informacion de la maquina
    public Machine save(@RequestBody Machine m){
        return machineService.save(m);
=======
    @PostMapping("/save")
    public Machine save(@RequestBody Machine p){
        return machineService.save(p);
>>>>>>> nicolas
    }

}
