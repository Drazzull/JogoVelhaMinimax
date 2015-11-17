/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaia1;

/**
 *
 * @author Kaszuba
 */
public class Sucessor {
    int tabuleiro[][];
    int utilidade;
    
    public Sucessor(int tab[][]){
        int tam = tab.length;
        tabuleiro = new int[tam][tam];
        
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                tabuleiro[i][j] = tab[i][j];
            }
        }
    }
}
