package com.lab2;

import java.util.Scanner;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GraphWriter extends Thread {
    Scanner in = new Scanner(System.in);
    Lock l = new ReentrantLock();  //Блок потока
    IGraph graph;
    CriticalSection criticalSection;

    public GraphWriter(IGraph Graph, CriticalSection criticalsection) {
        criticalSection = criticalsection;

        graph = Graph;
    }

    public void run() {
        if (!criticalSection.writerEnter()) return;
//Блок доступа для всех
        l.lock();
        while (true) {

            System.out.printf("введите команду:");
            switch (in.nextLine()) {
                case "addv":
                    graph.addVertice();
                    break;
                case "adde":
                    graph.addEdge();
                    break;
                case "exit":
                    criticalSection.writerExit();
                    //Разрешение доступа для всех
                    l.unlock();
                    return;
                default:
                    System.out.println("Такой команды не существует! Команды: addv, adde, exit");
            }
        }
    }
}


