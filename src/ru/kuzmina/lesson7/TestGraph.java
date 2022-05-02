package ru.kuzmina.lesson7;

public class TestGraph {
    public static void main(String[] args) {
        testWeightedGraph();
    }

    private static void testWeightedGraph() {
        WeightedGraph graph = new WeightedGraph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        System.out.println("Вариант №1:");
        setFirstPathIsBest(graph);
        graph.findPath("Москва", "Воронеж");
        System.out.println();

        System.out.println("Вариант №2:");
        setThirdPathIsBest(graph);
        graph.findPath("Москва", "Воронеж");


    }

    private static void setFirstPathIsBest(WeightedGraph graph) {
        graph.addWeightedEdge("Москва", "Тула", 180);
        graph.addWeightedEdge("Тула", "Липецк", 278);
        graph.addWeightedEdge("Липецк", "Воронеж", 134);

        graph.addWeightedEdge("Москва", "Рязань", 200);
        graph.addWeightedEdge("Рязань", "Тамбов", 288);
        graph.addWeightedEdge("Тамбов", "Саратов", 381);
        graph.addWeightedEdge("Саратов", "Воронеж", 507);

        graph.addWeightedEdge("Москва", "Калуга", 160);
        graph.addWeightedEdge("Калуга", "Орел", 217);
        graph.addWeightedEdge("Орел", "Курск", 163);
        graph.addWeightedEdge("Курск", "Воронеж", 230);
    }

    private static void setThirdPathIsBest(WeightedGraph graph) {
        graph.addWeightedEdge("Москва", "Тула", 180);
        graph.addWeightedEdge("Тула", "Липецк", 278);
        graph.addWeightedEdge("Липецк", "Воронеж", 134);

        graph.addWeightedEdge("Москва", "Рязань", 200);
        graph.addWeightedEdge("Рязань", "Тамбов", 288);
        graph.addWeightedEdge("Тамбов", "Саратов", 381);
        graph.addWeightedEdge("Саратов", "Воронеж", 507);

        graph.addWeightedEdge("Москва", "Калуга", 50);
        graph.addWeightedEdge("Калуга", "Орел", 110);
        graph.addWeightedEdge("Орел", "Курск", 80);
        graph.addWeightedEdge("Курск", "Воронеж", 23);
    }

}
