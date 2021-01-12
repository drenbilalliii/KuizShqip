package com.example.demo.service;

import com.example.demo.exceptions.NashornException;

import javax.script.ScriptException;

/**
 * @author Dren Bilalli on 1/12/2021
 */

public interface NashornService {


    String ekzekutoKodin(String kodi,String metoda) throws NashornException, ScriptException, NoSuchMethodException;

}
