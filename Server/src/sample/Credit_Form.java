package sample;

import java.io.Serializable;

class Credit_Form implements Serializable {

    private static final long serialVersionUID = 1L;

    public int cost;
    public int total;
    public String type;


    public Credit_Form(int cost, int total, String type)
    {
        this.cost = cost;
        this.total=total;
        this.type  = type;
    }

    public int Cost() {
        return cost;
    }

    public int Total() {
        return total;
    }

    public String Type() {
        return type;
    }

}