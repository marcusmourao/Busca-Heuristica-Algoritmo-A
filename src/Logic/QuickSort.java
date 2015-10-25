package Logic;

import java.util.ArrayList;
import Problem.State;

/**
 * Created by lucas on 24/10/15.
 */
public class QuickSort{


    public static void sort(float[] vetor)
    {
        sort(vetor, 0, vetor.length - 1);
    }

    private static void sort(float[] vetor, int inicio, int fim)
    {
        if (inicio < fim)
        {
            int posicaoPivo = split(vetor, inicio, fim);
            sort(vetor, inicio, posicaoPivo - 1);
            sort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int split(float[] vetor, int inicio, int fim)
    {
        float pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f)
        {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else
            {
                float troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}