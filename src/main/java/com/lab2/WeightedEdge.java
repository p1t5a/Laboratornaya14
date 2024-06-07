package com.lab2;

import java.util.Scanner;

public class WeightedEdge {
    Vertice source;
    Vertice receiver;
    String info;
    int weight;

    public WeightedEdge(Vertice source, Vertice receiver, String info) {
        Scanner in = new Scanner(System.in);

        this.source = source;
        this.receiver = receiver;
        this.info = info;

        System.out.printf("введите длину связи:");
        weight = in.nextInt();
    }

    public Vertice getSource() {
        return source;
    }

    public Vertice getReceiver() {
        return receiver;
    }

    public String getInfo() {
        return info;
    }

    public int getWeight() {
        return weight;
    }
}

