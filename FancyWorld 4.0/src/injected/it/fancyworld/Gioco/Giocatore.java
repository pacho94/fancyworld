package injected.it.fancyworld.Gioco;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import static injected.it.fancyworld.Utils.Utility.*;

/**
 * Created by enrico on 07/10/17.
 */
public class Giocatore implements Serializable
{
    private Point position;
    private String nome;
    private int pesoTotale, punteggio;
    private ArrayList<Chiave> chiavi;
    private final int LIM_INF_PUNTEGGIO = 0;

    public Giocatore(Point point, String nome)
    {
        this.position = point;
        this.nome = nome;
        chiavi = new ArrayList<>();
        this.pesoTotale = 0;
        this.punteggio = 10;
    }

    public void move(int way) 
    {
        switch (way) {
            case NORD:
                position.x -= 1;
                break;
            case SUD:
                position.x += 1;
                break;
            case EST:
                position.y += 1;
                break;
            case OVEST:
                position.y -= 1;
                break;
        }
    }
    public void setPosition(int x, int y)
    {
        position.x = x;
        position.y = y;
    }

    public Chiave getChiave(int index) {
        return chiavi.get(index);
    }

    public ArrayList<Chiave> getChiavi() {
        return chiavi;
    }

    public void addChiave(Chiave chiave) {
        chiavi.add(chiave);
    }

    public Point getPosition()
    {
        return position;
    }

    public String getNome()
    {
        return nome;
    }

    public int calculateTotalWeight()
    {
        int peso = 0;
        for(int i = 0; i < chiavi.size(); i++)
            peso += chiavi.get(i).getPeso();

        return peso;
    }

    public int getPunteggio() { return punteggio;}

    public void setPunteggio(int punteggio, Gioco.Sign sign)
    {
        if(sign.equals(Gioco.Sign.PLUS))
            this.punteggio += punteggio;
        else
            this.punteggio -= punteggio;
    }

    public void setPunteggioToMin()
    {
        punteggio = LIM_INF_PUNTEGGIO;
    }
}
