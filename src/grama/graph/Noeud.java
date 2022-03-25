package grama.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Noeud {

    private final List<Lien> liens;
    private char typeLieu;  // V : ville , L : loisir , R : restaurant
    private final String nom;

    public void setTypeLieu(char typeLieu) {
        if (typeLieu == 'V' || typeLieu == 'L' || typeLieu == 'R')
        {
            this.typeLieu = typeLieu;
        }
    }

    public Noeud(char newTypeLieu, String newNom)
    {
        liens = new LinkedList<>();
        this.typeLieu = newTypeLieu;
        this.nom = newNom;
    }


    public void addLien(Lien lien)
    {
        liens.add(lien);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noeud noeud = (Noeud) o;
        return typeLieu == noeud.typeLieu && Objects.equals(nom, noeud.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeLieu, nom);
    }


}
