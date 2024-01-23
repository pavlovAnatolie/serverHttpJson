package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {


    private static void sendFile(DataOutputStream out, String path,Object o){
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            String f = objectMapper.writeValueAsString(o);
            if (path.endsWith("json")) {
                
            
            out.writeBytes("HTTP/1.1 200 OK \n");
            out.writeBytes("Content-Length: "+ f.length()+"\n" );
            out.writeBytes("Server: Java HTTP Server from Pavlov: 1.0"+ "\n");
            out.writeBytes("Date: "+ new Date() +"\n" );
            out.writeBytes("Content-Type: application/json; charset=utf-8 \n");
            out.writeBytes("\n");

            out.writeBytes(f);

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
    }
    public static void main(String[] args) {
        try {

            ServerSocket server = new ServerSocket(8080);
            System.out.println("server attivo");
            
            while(true){
                Socket s = server.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                String linkSearch= in.readLine();
                String[] linkFinder = linkSearch.split(" ");
                String path = linkFinder[1];
                //path = "prova" +  path;
                System.out.println(path);

                if(path.equals("/classe.json")){
                    Studente s1 = new Studente("Pippo","Pascal",new Date(2000,05,10));
           Studente s2 = new Studente("Anatolie", "Pavlov", new Date(2002,12,10));
           Studente s3 = new Studente("Riccardo", "Grandi", new Date(2003,03,7));
           Studente s4 = new Studente("Alessio", "Didilescu", new Date(2004,04,03));
           Studente s5 = new Studente("Gigi", "Topolone", new Date(2005,06,19));


           Classe cls = new Classe(5, "DIA", "08-2W");
           cls.addStudente(s1);
           cls.addStudente(s2);
           cls.addStudente(s3);
           cls.addStudente(s4);
           cls.addStudente(s5);

                    sendFile(out, path, cls);
                }

                s.close();


            }
                

            
            
        } catch (Exception e) {
            
        }
    }

}