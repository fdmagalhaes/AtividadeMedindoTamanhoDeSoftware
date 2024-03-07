import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        final int P = 10000000; // Total de pessoas a serem inseridas
        final int N = 40000; // Total de buscas a serem realizadas
        final int MAX_ID = P; // Máximo valor do ID
        final int SEED = 42; // Semente para geração de números aleatórios

        Random rand = new Random(SEED);

        // Inserindo pessoas em um ArrayList
        ArrayList<Pessoa> arrayListPessoas = new ArrayList<>();
        for (int i = 1; i <= P; i++) {
            Pessoa pessoa = new Pessoa(i, "Pessoa " + i);
            arrayListPessoas.add(pessoa);
        }

        // Inserindo pessoas em um HashMap
        HashMap<Integer, Pessoa> hashMapPessoas = new HashMap<>();
        for (int i = 1; i <= P; i++) {
            Pessoa pessoa = new Pessoa(i, "Pessoa " + i);
            hashMapPessoas.put(i, pessoa);
        }

        // Realizando N buscas em ArrayList
        long startTimeArrayList = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int randomId = rand.nextInt(MAX_ID) + 1;
            for (Pessoa pessoa : arrayListPessoas) {
                if (pessoa.getId() == randomId) {
                    break;
                }
            }
        }
        long endTimeArrayList = System.nanoTime();
        long durationArrayList = endTimeArrayList - startTimeArrayList;

        // Realizando N buscas em HashMap
        long startTimeHashMap = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int randomId = rand.nextInt(MAX_ID) + 1;
            hashMapPessoas.get(randomId);
        }
        long endTimeHashMap = System.nanoTime();
        long durationHashMap = endTimeHashMap - startTimeHashMap;

        System.out.println("Tempo total de buscas em ArrayList: " + durationArrayList + " nanossegundos");
        System.out.println("Tempo total de buscas em HashMap: " + durationHashMap + " nanossegundos");
    }
}

class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}