package com.lab2;

public class Edge {
    Vertice source;
    Vertice receiver;
    String info;

    public Edge(Vertice source, Vertice receiver, String info) {
        this.source = source;
        this.receiver = receiver;
        this.info = info;
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
}

