package com.lab2;

import java.util.Scanner;

public class GraphReader extends Thread {
    Scanner in = new Scanner(System.in);

    IGraph graph;
    CriticalSection criticalSection;

    public GraphReader(IGraph Graph, CriticalSection criticalsection) {
        criticalSection = criticalsection;

        graph = Graph;
    }

    public void run() {
        if (graph == null) {
            System.out.println("Граф ещё не был создан!");
            return;
        }

        if (!criticalSection.readerEnter()) return;

        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.printf("введите команду:");
            switch (in.nextLine()) {
                // матрица смежности
                case "showAdjacency":
                    graph.showAdjacency();
                    break;
                //матрица инцидентности
                case "showIncidence":
                    graph.showIncidence();
                    break;
                case "exit":
                    criticalSection.readerExit();
                    return;
                default:
                    System.out.println("Такой команды не существует! Команды: showAdjacency, showIncidence, exit");
            }
        }
    }
}

