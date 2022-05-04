package ru.kuzmina.lesson7;

import java.util.*;

public class WeightedGraph implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;


    public WeightedGraph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = 0;
        return true;
    }

    @Override
    public boolean addWeightedEdge(String startLabel, String secondLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        visitVertex(stack, vertex, true);
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex, boolean showVisited) {
        if (showVisited) {
            System.out.print(vertex.getLabel() + " ");
        }
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex == null) {
                stack.pop();
            } else {
                visitVertex(stack, vertex);
            }
        }
    }

    public void findPath(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }
        if (endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + endLabel);
        }

        List<Vertex> bestWay = new ArrayList<>();
        int bestWayDistance = 0;
        int distance = 0;

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (stack.peek().getLabel().equals(startLabel) && vertex != null) {
                vertexList.get(endIndex).setVisited(false);
                distance = 0;
            }
            if (vertex == null || stack.peek().getLabel().equals(endLabel)) {
                if (stack.peek().getLabel().equals(endLabel) && bestWayDistance == 0 || distance < bestWayDistance) {
                    bestWayDistance = distance;
                    bestWay.clear();
                    bestWay.addAll(stack);
                }
                stack.pop();
            } else {
                distance += getDistance(stack.peek(), vertex);
                visitVertex(stack, vertex, false);
            }
        }
        unvisitedAll();
        System.out.printf("Кратчайший путь из пункта: %s до пункта: %s составляет %d км. \n", startLabel, endLabel, bestWayDistance);
        System.out.println("Маршрут: " + bestWay);
    }

    private int getDistance(Vertex vertex, Vertex nearVertex) {
        int startIndex = indexOf(vertex.getLabel());
        int endIndex = indexOf(nearVertex.getLabel());

        if (startIndex == -1 || endIndex == -1) {
            return -1;
        }

        return adjMatrix[startIndex][endIndex];
    }

    private void unvisitedAll() {
        for (Vertex vertex: vertexList) {
            vertex.setVisited(false);
        }
    }
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue, vertex);
            }
        }
    }

}

