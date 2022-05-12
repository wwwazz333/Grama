package grama.calcule.matrix;

import grama.graph.Graph;
import grama.graph.Noeud;

public class FloydWarshall extends Matrix<FloydWarshall.Couple> {

    private static FloydWarshall instance;

    public static FloydWarshall getInstance() {
        if (instance == null) {
            instance = new FloydWarshall(0, new Couple(null, null));
        }
        return instance;
    }

    static class Couple {

        private Integer val;//si val est null alors on considérera que la valeur est infinie.
        private Noeud prec;

        public Couple(Integer val, Noeud prec) {
            this.val = val;
            this.prec = prec;
        }

        @Override
        public String toString() {
            return "(" + val + ", " + prec + ')';
        }

    }

    public FloydWarshall(Matrix<Couple> other) {
        super(other);
    }

    public FloydWarshall(Couple[][] array) {
        super(array);
    }

    public FloydWarshall(int length, Couple defaut) {
        super(length, defaut);
    }

    public FloydWarshall(Graph g) {
        super(g.getListNoeud().size(), new Couple(null, null));

        init(g);
    }

    /**
     * résouse avec l'algorithme de FloyWarshall
     * @return this
     */
    public FloydWarshall resolve() {
        for (int currStep = 0; currStep < matrix.size(); currStep++) {
            for (int row = 0; row < matrix.size(); row++) {
                if (row == currStep) {
                    continue;
                }
                for (int col = 0; col < matrix.size(); col++) {
                    if (row == currStep) {
                        continue;
                    }

                    if (row != col /*optimisation*/ && matrix.get(currStep).get(col).val != null && matrix.get(row).get(currStep).val != null) {//si additionne avec un infini (null) => forcément pas mieux
                        int sum = matrix.get(currStep).get(col).val + matrix.get(row).get(currStep).val;
                        Noeud previousNode = matrix.get(currStep).get(col).prec;
                        if (matrix.get(row).get(col).val == null || sum < matrix.get(row).get(col).val) {//meilleur chemin, doit être changé
                            matrix.get(row).set(col, new Couple(sum, previousNode));
                        }
                    }

                }
            }
        }

        return this;
    }

    /**
     * initialize comme re créé un objet FloyWarshall
     * @param g le graph avec lequelle initilizer
     * @return this
     */
    public FloydWarshall init(Graph g) {
        super.init(g.getListNoeud().size(), new Couple(null, null));
        
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.size(); col++) {
                if (col == row) {
                    matrix.get(row).set(col, new Couple(0, null));
                } else {
                    Integer distance = g.getListNoeud().get(row).getDistanceTo(g.getListNoeud().get(col));
                    matrix.get(row).set(col, new Couple(distance, g.getListNoeud().get(row)));
                }
            }
        }
        return this;
    }

    public static FloydWarshall initFloydWarshall(Graph g) {
        FloydWarshall m = new FloydWarshall(g.getListNoeud().size(), new Couple(null, null));
        return m.init(g);
    }
}
