package com.lab2;

import org.springframework.context.annotation.*;

import java.util.Scanner;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("logger")

public class AppConfig {

    @Bean  @Scope("singleton")
    public CriticalSection criticalSection() {return new CriticalSection();}

    @Bean
    @Scope("singleton")
    public IGraph AppConf(){

        Scanner in = new Scanner(System.in);

        IGraph graph;
        graph = new UnweightedGraph();

        System.out.println("какого типа граф вы хотите создать?\n1.Невзвешенный \t 2.Взвешенный");

            switch (in.nextLine()) {

            case "1":graph = new UnweightedGraph();break;

            case "2":   graph = new WeightedGraph();break;

            default:System.out.println("Граф такого типа не может быть создан");;


        }
        return graph;
    }
}
