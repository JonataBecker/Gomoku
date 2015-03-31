package br.com.gomoku;

import java.util.Enumeration;
import javax.comm.CommPortIdentifier;

public class TesteSerial {
    
    /*
    -> Criar JRE para execução
    
    Copy 'win32com.dll' to JDK_HOME\jre\bin.
    Copy 'javax.comm.properties'to to JDK_HOME\jre\lib.
    Copy 'comm.jar'to to JDK_HOME\jre\lib\ext.
    */
    
    public static void main(String[] args) {   
        getPortas();
    }
        
    private static void getPortas() {
        Enumeration listaDePortas = CommPortIdentifier.getPortIdentifiers(); 
        int i = 0; 
        while (listaDePortas.hasMoreElements()) { 
            CommPortIdentifier ips = (CommPortIdentifier)listaDePortas.nextElement(); 
            System.out.println(ips.getName());
        }
    }
    
}
