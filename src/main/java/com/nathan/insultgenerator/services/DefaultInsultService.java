package com.nathan.insultgenerator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import com.nathan.insultgenerator.models.Insult;

import org.springframework.stereotype.Service;

@Service
public class DefaultInsultService implements InsultService {

    List<String> insultsList;
 
    @PostConstruct
    private void initInsultsList() {
        insultsList = new ArrayList<>();
        insultsList.add("silly");
        insultsList.add("daft");
        insultsList.add("crazy");
        insultsList.add("foolish");
    }
    
    private String getRandomInsult()
    {
        int sizeofInsultsList = insultsList.size();
        int randomInsultLocation = ThreadLocalRandom.current().nextInt(sizeofInsultsList);
        return insultsList.get(randomInsultLocation);
    }


    @Override
    public Insult getInsultForPerson(String name) {
        
        return new Insult(name, getRandomInsult() );
    }
    
}
