package com.nathan.insultgenerator.services;

import com.nathan.insultgenerator.models.Insult;

public interface InsultService {
    public Insult getInsultForPerson(String name);
}
