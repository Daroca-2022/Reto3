package com.usa.mintic.reto3.repository.crudRepository;

import com.usa.mintic.reto3.model.Machine;
import org.springframework.data.repository.CrudRepository;

//interface hereda de crudRepository es de spring para conexion con bd tabla Machine atraves tipo llave primaria
public interface MachineCrudRepository extends CrudRepository<Machine,Integer> {
}
