package com.usa.mintic.reto3.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer id) {
        this.idMessage = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
//Client, machine


}
