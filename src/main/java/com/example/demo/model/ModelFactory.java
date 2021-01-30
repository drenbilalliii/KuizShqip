package com.example.demo.model;

/**
 * @author Dren Bilalli on 1/24/2021
 */

public class ModelFactory {


    public  static <T> T  getInstanceOfModel(String emriKlases){
        if(emriKlases.equals("PyetjaEntity")){
            return (T) new PyetjaEntity();
        }
        else if(emriKlases.equals("KuiziEntity")){
            return (T) new KuiziEntity();
        }
        else if(emriKlases.equals("PerdoruesiEntity")){
            return (T) new PerdoruesiEntity();
        }
        else if(emriKlases.equals("KuizeteluajtuaraEntity")){
            return (T) new KuizeteluajturaEntity();
        }
        else if(emriKlases.equals("JsPytjeEntity")){
            return (T)new JsPytjeEntity();
        }

        return null;
    }




}