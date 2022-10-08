package com.usa.mintic.reto3.repository;

import com.usa.mintic.reto3.model.Machine;
import com.usa.mintic.reto3.repository.crudRepository.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class MachineRepository {
    //liga el repositorio con el servicio y instancia a la clase Machine
    @Autowired
    //cuando nos solicitan guardar, traer informacion llama MachineCrudRepository o interface
    private MachineCrudRepository machineCrudRepository;

    //muestras la lista de todos las maquinas  select * from machine
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    //select * from machine where id =10
    //El metodo trae un elemento por Id y tipo de dato Optional trae un objeto si no hay nada no trae pero puedo ?
    public Optional<Machine> getById(int id){
        return machineCrudRepository.findById(id);
    }

    //save si el objeto existe lo actualiza y sino lo crea
    public Machine save(Machine m){
        return machineCrudRepository.save(m);
    }

    public void delete (Machine m){
        machineCrudRepository.delete(m);
    }

}
