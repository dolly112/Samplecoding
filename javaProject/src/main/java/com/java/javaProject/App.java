package com.java.javaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    ArrayList<String> a= new ArrayList<String>();
    a.add("Apple");
    a.add("Befyg");
    a.add("Cat");
    a.add("Dog");
    
   List<String> values = a.stream().filter(a1-> a1.contains("Dsdsd")).collect(Collectors.toList());
    
   System.out.println(values);
   
    }
}
