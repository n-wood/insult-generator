package com.nathan.insultgenerator.controllers;

import com.nathan.insultgenerator.models.Insult;
import com.nathan.insultgenerator.services.InsultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsultController { 

    @Autowired
    InsultService service;


    @RequestMapping(path = "insult/name/{name}")
    public Insult getInsultForPerson(@PathVariable(name = "name") String name){

        return service.getInsultForPerson(name);
    }
    
}
