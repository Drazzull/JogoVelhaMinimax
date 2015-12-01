/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaia1;

/**
 *
 * @author José Luiz
 */
public class Tabuleiro
{
    private final char[][] tab = new char[3][3];

    public Tabuleiro()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                this.tab[i][j] = '-';
            }
        }
    }

    public boolean marcaX(int x, int y)
    {
        if (x >= 3 || x < 0 || y >= 3 || y < 0)
        {
            return false;
        }
        if (tab[x][y] != 'O' && tab[x][y] != 'X')
        {
            this.tab[x][y] = 'X';
            return true;
        }
        return false;
    }

    public boolean marcaO(int x, int y)
    {
        if (x >= 3 || x < 0 || y >= 3 || y < 0)
        {
            return false;
        }
        if (tab[x][y] != 'O' && tab[x][y] != 'X')
        {
            this.tab[x][y] = 'O';
            return true;
        }
        return false;
    }

    public boolean marcaVazio(int x, int y)
    {
        if (x >= 3 || x < 0 || y >= 3 || y < 0)
        {
            return false;
        }
        this.tab[x][y] = '-';
        return true;
    }

    public boolean fimdejogo()
    {
        if (tab[0][0] == 'X' && tab[0][1] == 'X' && tab[0][2] == 'X')
        {
            return true;
        }
        if (tab[1][0] == 'X' && tab[1][1] == 'X' && tab[1][2] == 'X')
        {
            return true;
        }
        if (tab[2][0] == 'X' && tab[2][1] == 'X' && tab[2][2] == 'X')
        {
            return true;
        }
        if (tab[0][0] == 'O' && tab[0][1] == 'O' && tab[0][2] == 'O')
        {
            return true;
        }
        if (tab[1][0] == 'O' && tab[1][1] == 'O' && tab[1][2] == 'O')
        {
            return true;
        }
        if (tab[2][0] == 'O' && tab[2][1] == 'O' && tab[2][2] == 'O')
        {
            return true;
        }
        if (tab[0][0] == 'X' && tab[1][0] == 'X' && tab[2][0] == 'X')
        {
            return true;
        }
        if (tab[0][1] == 'X' && tab[1][1] == 'X' && tab[2][1] == 'X')
        {
            return true;
        }
        if (tab[0][2] == 'X' && tab[1][2] == 'X' && tab[2][2] == 'X')
        {
            return true;
        }
        if (tab[0][0] == 'O' && tab[1][0] == 'O' && tab[2][0] == 'O')
        {
            return true;
        }
        if (tab[0][1] == 'O' && tab[1][1] == 'O' && tab[2][1] == 'O')
        {
            return true;
        }
        if (tab[0][2] == 'O' && tab[1][2] == 'O' && tab[2][2] == 'O')
        {
            return true;
        }
        if (tab[0][0] == 'X' && tab[1][1] == 'X' && tab[2][2] == 'X')
        {
            return true;
        }
        if (tab[0][0] == 'O' && tab[1][1] == 'O' && tab[2][2] == 'O')
        {
            return true;
        }
        if (tab[2][0] == 'X' && tab[1][1] == 'X' && tab[0][2] == 'X')
        {
            return true;
        }
        if (tab[2][0] == 'O' && tab[1][1] == 'O' && tab[0][2] == 'O')
        {
            return true;
        }
        return tab[0][0] != '-' && tab[0][1] != '-' && tab[0][2] != '-' && tab[1][0] != '-' && tab[1][1] != '-' && tab[1][2] != '-' && tab[2][0] != '-' && tab[2][1] != '-' && tab[2][2] != '-';
    }

    public boolean empate()
    {
        return tab[0][0] != '-' && tab[0][1] != '-' && tab[0][2] != '-' && tab[1][0] != '-' && tab[1][1] != '-' && tab[1][2] != '-' && tab[2][0] != '-' && tab[2][1] != '-' && tab[2][2] != '-';
    }

    public char[][] getTabuleiro()
    {
        return tab;
    }
}
