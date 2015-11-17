/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaia1;

import javax.swing.JOptionPane;

/**
 *
 * @author José Luiz
 */
public class MinMax {

    private final int vitoriaHumano = 1;
    private final int empate = 2;
    private final int vitoriaComputador = 3;
    private int humano = 4;
    private int computador = 5;
    private int profundidade = 0;
    private long nos = 0;
    private int turno = 0;

    private Coordenada melhorJogada = new Coordenada();

    public int miniMax(Tabuleiro tabuleiro, int lado, int alpha, int beta, Coordenada melhorJogada) {
        int oponente;
        int repeticao;
        int valor;
        oponente = repeticao = valor = 0;
        Coordenada dc = new Coordenada();

        if (tabuleiro.fimdejogo() && turno == humano) {
            return vitoriaHumano;
        } else if (tabuleiro.fimdejogo() && turno == computador) {
            return vitoriaComputador;
        } else if (tabuleiro.empate()) {
            return empate;
        }

        if (lado == computador) {
            oponente = humano;
            valor = alpha;
        } else {
            oponente = computador;
            valor = beta;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro.getTabuleiro()[i][j] == '-') {
                    if (lado == computador) {
                        tabuleiro.marcaX(i, j);
                    } else {
                        tabuleiro.marcaO(j, j);
                    }

                    profundidade = i + j;
                    nos++;
                    if (lado == computador) {
                        turno = humano;
                    } else {
                        turno = computador;
                    }
                    repeticao = miniMax(tabuleiro, oponente, alpha, beta, melhorJogada);

                    tabuleiro.marcaVazio(i, j);

                    if (((lado == computador) && (repeticao > valor)) || ((lado == humano) && (repeticao < valor))) {
                        if (lado == computador) {
                            alpha = repeticao;
                            valor = repeticao;
                        } else {
                            beta = repeticao;
                            valor = repeticao;
                        }
                        melhorJogada.setX(i);
                        melhorJogada.setY(j);
                        if (alpha >= beta) {
                            return valor;
                        }
                    }
                }
            }
        }
        return valor;
    }

    public Coordenada jogadaComputador(Tabuleiro tabuleiro) {
        turno = computador;
        Tabuleiro copia = tabuleiro;
        miniMax(copia, computador, vitoriaHumano, vitoriaComputador, melhorJogada);
        return this.melhorJogada;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public long getNos() {
        return nos;
    }

    public void setNos(long nos) {
        this.nos = nos;
    }

}
