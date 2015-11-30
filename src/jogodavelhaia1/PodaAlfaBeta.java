/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaia1;

import java.util.ArrayList;

/**
 *
 * @author Kaszuba
 */
public class PodaAlfaBeta
{
    static ArrayList<Sucessor> sucessores = new ArrayList<>();
    public int tam, maxProf, nos, profundidade;

    public PodaAlfaBeta(int tam)
    {
        this.tam = tam;
        this.maxProf = Integer.MAX_VALUE;
        this.nos = 0;
        this.profundidade = 0;
    }

    public int[][] tabuleiroEmValores(Tabuleiro tabuleiro, int tam)
    {
        int[][] valores = new int[tam][tam];
        for (int i = 0; i < tam; i++)
        {
            for (int j = 0; j < tam; j++)
            {
                if (tabuleiro.getTabuleiro()[i][j] == '-')
                {
                    valores[i][j] = 0;
                } else
                {
                    if (tabuleiro.getTabuleiro()[i][j] == 'X')
                    {
                        valores[i][j] = 1;
                    } else
                    {
                        valores[i][j] = -1;
                    }
                }
            }
        }
        return valores;
    }

    public Tabuleiro valoresEmTabuleiro(int[][] tab, int tam)
    {
        Tabuleiro retorno = new Tabuleiro();
        for (int i = 0; i < tam; i++)
        {
            for (int j = 0; j < tam; j++)
            {
                if (tab[i][j] == 0)
                {
                    retorno.marcaVazio(i, j);
                } else
                {
                    if (tab[i][j] == 1)
                    {
                        retorno.marcaX(i, j);
                    } else
                    {
                        retorno.marcaO(i, j);
                    }
                }
            }
        }
        return retorno;
    }

    public int[][] decisaoMiniMax(int[][] tab)
    {
        sucessores.clear();
        profundidade = 0;
        nos = 0;
        int v = valorMax(tab, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        for (Sucessor s : sucessores)
        {
            if (s.utilidade == v)
            {
                nos = sucessores.size();
                return s.tabuleiro;
            }
        }
        return tab;
    }

    public int valorMax(int[][] tab, int alfa, int beta, boolean prim)
    {
        profundidade++;
        if (testeTerminal(tab))
        {
            return utilidade(tab);
        }
        int v = Integer.MIN_VALUE;
        for (Sucessor s : gerarSucessores(tab, 1))
        {
            v = Math.max(v, valorMin(s.tabuleiro, alfa, beta));
            s.utilidade = v;
            if (prim)
            {
                sucessores.add(s);
            }
            if (v >= beta)
            {
                return v;
            }
            alfa = Math.max(alfa, v);
        }
        return v;
    }

    public int valorMin(int[][] tab, int alfa, int beta)
    {
        profundidade++;
        if (testeTerminal(tab))
        {
            return utilidade(tab);
        }
        int v = Integer.MAX_VALUE;
        for (Sucessor s : gerarSucessores(tab, -1))
        {
            v = Math.min(v, valorMax(s.tabuleiro, alfa, beta, false));
            s.utilidade = v;
            if (v <= alfa)
            {
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }

    public boolean testeTerminal(int[][] tab)
    {
        return (ganhou(tab, 1) || ganhou(tab, -1) || semEspaco(tab));
    }

    public boolean ganhou(int[][] tab, int v)
    {
        for (int i = 0; i < tam; i++)
        {
            if (ganhouLinha(tab, i, v) || ganhouColuna(tab, i, v))
            {
                return true;
            }
        }
        if (ganhouDiagonalPrincipal(tab, v) || ganhouDiagonalSecundaria(tab, v))
        {
            return true;
        }
        return false;
    }

    public boolean ganhouLinha(int[][] tab, int l, int v)
    {
        for (int i = 0; i < tam; i++)
        {
            if (tab[l][i] != v)
            {
                return false;
            }
        }
        return true;
    }

    public boolean ganhouColuna(int[][] tab, int c, int v)
    {
        for (int i = 0; i < tam; i++)
        {
            if (tab[i][c] != v)
            {
                return false;
            }
        }
        return true;
    }

    public boolean ganhouDiagonalPrincipal(int[][] tab, int v)
    {
        for (int i = 0; i < tam; i++)
        {
            if (tab[i][i] != v)
            {
                return false;
            }
        }
        return true;
    }

    public boolean ganhouDiagonalSecundaria(int[][] tab, int v)
    {
        for (int i = 0; i < tam; i++)
        {
            if (tab[(tam - 1) - i][i] != v)
            {
                return false;
            }
        }
        return true;
    }

    public boolean semEspaco(int tab[][])
    {
        for (int i = 0; i < tam; i++)
        {
            for (int j = 0; j < tam; j++)
            {
                if (tab[i][j] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int utilidade(int tab[][])
    {
        if (ganhou(tab, 1))
        {
            return 1;
        } else
        {
            if (ganhou(tab, -1))
            {
                return -1;
            } else
            {
                return 0;
            }
        }
    }

    public ArrayList<Sucessor> gerarSucessores(int tab[][], int v)
    {
        ArrayList<Sucessor> suc = new ArrayList<>();
        for (int i = 0; i < tam; i++)
        {
            for (int j = 0; j < tam; j++)
            {
                if (tab[i][j] == 0)
                {
                    tab[i][j] = v;
                    suc.add(new Sucessor(tab));
                    tab[i][j] = 0;
                }
            }
        }
        return suc;
    }

    public Coordenada jogadaComputador(Tabuleiro tabuleiro)
    {
        int[][] valores = decisaoMiniMax(tabuleiroEmValores(tabuleiro, tam));
        Tabuleiro jogada = valoresEmTabuleiro(valores, tam);
        Coordenada retorno = new Coordenada();
        for (int i = 0; i < tam; i++)
        {
            for (int j = 0; j < tam; j++)
            {
                if (tabuleiro.getTabuleiro()[i][j] != jogada.getTabuleiro()[i][j])
                {
                    retorno.setX(i);
                    retorno.setY(j);
                }
            }
        }
        return retorno;
    }
}
