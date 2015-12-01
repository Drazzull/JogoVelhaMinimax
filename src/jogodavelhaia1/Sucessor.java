/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaia1;

/**
 *
 * @author André Filipe de Moraes Batista, Luiz Fernando de Oliveira Jacintho
 * Disponível em: http://aleph0.info/cursos/ia/trab/luis/3/J2Velha.pdf
 */
public class Sucessor
{
    int tabuleiro[][];
    int utilidade;

    public Sucessor(int tab[][])
    {
        int tam = tab.length;
        tabuleiro = new int[tam][tam];
        for (int i = 0; i < tam; i++)
        {
            System.arraycopy(tab[i], 0, tabuleiro[i], 0, tam);
        }
    }
}
