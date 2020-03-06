/*
 * The MIT License
 *
 * Copyright 2020 bieito.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.bieitosousa.di06_javahelp_maven;

/**
 *
 * @author bieito
 */
import java.io.File;
import javax.help.*;
import java.net.*;

public class Contenidos {

    static final String hsRuta =  "."+File.separator+"help" + File.separator + "help_set.hs";
    

    public  HelpSet start() {
        HelpSet hs = null;
        System.out.println("la ruta es "+hsRuta);
        try {
            File fileHelpSet = new File(hsRuta);//localiza el fichero helpset
            URL hsURL = fileHelpSet.toURI().toURL();
             hs = new HelpSet(getClass().getClassLoader(), hsURL); // crea un objeto Helpset
        } catch (Exception e) {
            System.out.println("[ERROR: START HelpSet]"+e.getMessage());   
        }
        return hs;
    }

    public  HelpBroker help(){
        
        HelpSet hs = null;
        HelpBroker hb = null;
         try {
        if ((hs = start())!= null){
        hb = hs.createHelpBroker ();
        }else {System.out.println("no se ha creado el objeto HelpSet ");}
        } catch (Exception et) {
            System.out.println("[ERROR: BUILD HelpBroker ]"+et.getMessage());   
        }
        return hb;
    }
    public  HelpBroker help(HelpSet hs){
        HelpBroker hb = null;
         try {
        if (hs != null){
        hb = hs.createHelpBroker ();
        }else{System.out.println("NO SE HA CREADO EL OBJETO HelpBroker");}
        } catch (Exception et) {
            System.out.println("[ERROR: BUILD HelpBroker ]"+et.getMessage());   
        }
        return hb;
    }
}
