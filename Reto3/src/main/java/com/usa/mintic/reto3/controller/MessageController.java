package com.usa.mintic.reto3.controller;

import com.example.demoo.model.Message;
import com.example.demoo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }

}
