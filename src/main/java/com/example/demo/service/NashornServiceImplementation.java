package com.example.demo.service;

import com.example.demo.exceptions.NashornException;
import org.springframework.stereotype.Service;

import javax.script.*;
import java.security.SecureRandom;

/**
 * @author Dren Bilalli on 1/12/2021
 */

@Service
public class NashornServiceImplementation implements NashornService {


    private ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("js");

    @Override
    public String ekzekutoKodin(String kodi,String metoda) throws NashornException, ScriptException, NoSuchMethodException {

        Invocable invocable = (Invocable)scriptEngine;

       Object o = invocable.invokeFunction(metoda,null);

       return o.toString();

    }
}
