package com.usa.mintic.reto3.service;

import com.usa.mintic.reto3.model.Machine;
import com.usa.mintic.reto3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }

    public Optional<Machine> getById(int id){
        return machineRepository.getById(id);
    }

    public Machine save(Machine m){
       return machineRepository.save(m);
    }

    public void delete (Machine m){
        machineRepository.delete(m);
    }

}
