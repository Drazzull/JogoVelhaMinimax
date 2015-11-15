/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaia1;

/**
 *
 * @author José Luiz
 */
public class MinMax {
    private char jogador;

    public MinMax(char jogador) {
        this.jogador = jogador;
    }
    /*public void novoJogo(Tabuleiro tabuleiro){
        if(jogador == 'P'){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(tabuleiro.getTabuleiro()[i][j] == '-'){
                        abrirEstadosMax(tabuleiro, i, j);
                    }
                }
            }
        }
    }
    
    /*public int abrirEstadosMax(Tabuleiro tabuleiro, int x, int y){
        Tabuleiro proxEstado = tabuleiro;
        proxEstado.marcaX(x, y);
        for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(tabuleiro.getTabuleiro()[i][j] == '-'){
                        abrirEstadosMin(proxEstado, i, j);
                    }
                }
    }
    }
    
    public int abrirEstadosMin(Tabuleiro tabuleiro, int x, int y){
        Tabuleiro proxEstado = tabuleiro;
        proxEstado.marcaO(x, y);
        
    }*/
}
