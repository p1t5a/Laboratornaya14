package com.lab2;

import java.util.ArrayList;
import java.util.Scanner;
public class UnweightedGraph implements IGraph {
    Scanner in = new Scanner(System.in);

    ArrayList<Vertice> vertices;
    ArrayList<Edge> edges;

    public UnweightedGraph() {

        vertices = new ArrayList<Vertice>();

        edges = new ArrayList<Edge>();
    }

    public void addVertice() {
        vertices.add(new Vertice());
    }

    public void addEdge() {
        int i;

        System.out.print("введите название вершины источника:");
        String sourceName = in.nextLine();

        int sourceIndex = -1;
        i = 0;
        for (Vertice vertice : vertices) {
            if (vertice.getName().equals(sourceName)) {
                sourceIndex = i;
                break;
            }
            i++;
        }

        System.out.print("введите название вершины приёмника:");
        String receiverName = in.nextLine();

        int receiverIndex = -1;
        i = 0;
        for (Vertice vertice : vertices) {
            if (vertice.getName().equals(receiverName)) {
                receiverIndex = i;
                break;
            }
            i++;
        }

        if (sourceIndex == -1 || receiverIndex == -1) {
            System.out.println("создать связь невозможно: попытка связать несуществующую вершину");
            return;
        }

        System.out.print("введите описание отношения:");
        String info = in.nextLine();

        Edge nextEdge = new Edge(vertices.get(sourceIndex), vertices.get(receiverIndex), info);
        edges.add(nextEdge);
    }

    public void showAdjacency() {
        int[][] adjacencyMatrix = new int[vertices.size()][vertices.size()];

        for (Edge edge : edges) {
            adjacencyMatrix[vertices.indexOf(edge.getSource())][vertices.indexOf(edge.getReceiver())]++;
        }

        int size = vertices.size();
        for (Vertice vertice : vertices)
            System.out.print("\t\t" + vertice.getName());

        System.out.println();

        for (int y = 0; y < size; y++) {
            System.out.print(vertices.get(y).getName());
            for (int x = 0; x < size; x++) {
                System.out.print("\t\t" + adjacencyMatrix[y][x]);
            }
            System.out.println();
        }
    }

    public void showIncidence() {
        int[][] incidenceMatrix = new int[vertices.size()][edges.size()];

        for (Edge edge : edges) {
            incidenceMatrix[vertices.indexOf(edge.getSource())][edges.indexOf(edge)] = 1;
            incidenceMatrix[vertices.indexOf(edge.getReceiver())][edges.indexOf(edge)] = -1;
        }

        int i = 0;
        for (Edge edge : edges)
            System.out.print("\t\t" + i++);

        System.out.println();

        for (int y = 0; y < vertices.size(); y++) {
            System.out.print(vertices.get(y).getName());
            for (int x = 0; x < edges.size(); x++) {
                System.out.print("\t\t" + incidenceMatrix[y][x]);
            }
            System.out.println();
        }

    }
}