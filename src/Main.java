import Problem.Solution;

public class Main {

    public static void main(String[] args) {

        System.out.println("---Busca Heuristica---");

        Solution sol = new Solution();
        System.out.println("-- Estado inicial --");
        sol.showInit_puzzle();
        System.out.println("-- Estado objetivo --");
        sol.showSolution();
        System.out.println("-- Estado final gerado pelo algoritmo --");
        sol.generate_solution();



    }
}
