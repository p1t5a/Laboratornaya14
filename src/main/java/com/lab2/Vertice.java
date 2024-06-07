package com.lab2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Scanner;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("logger")
public class Vertice {


    String name;
    String info;


    public Vertice() {
        Scanner in = new Scanner(System.in);

        System.out.printf("введите название вершины:");
        name = in.nextLine();

        System.out.printf("введите описание вершины:");
        info = in.nextLine();
    }


    public Vertice(String name, String info) {this.name = name;     this.info = info;   }


    public String getName() {
        return name;
    }


    public String getInfo() {return info;}
}

