/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dli
 */
public class Utilization {
    
    public static List<String> getTodos(){
        String path = "todos";
        List<String> todos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
                while (line != null) {
                    todos.add(line);
                    line = br.readLine();
                }
            }catch(Exception e){
                System.out.println(e);
            }
        return todos;  
    }
    
    public static void saveTodos(List<String> todos){
        String path = "todos";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            StringBuilder sb = new StringBuilder();
            sb.append(todos.get(0));
            for(int i=1;i<todos.size();i++){
                sb.append("\n");
                sb.append(todos.get(i));
            }
            bw.write(sb.toString());
            bw.flush();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
