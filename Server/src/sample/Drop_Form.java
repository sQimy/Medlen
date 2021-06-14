package sample;

import java.io.Serializable;

class Drop_Form implements Serializable {

    private static final long serialVersionUID = 1L;

    public int cost;
    public int total;
    public String type;
    public String status;


    public Drop_Form(int cost, int total, String type, String status)
    {
        this.cost = cost;
        this.total=total;
        this.type  = type;
        this.status = status;
    }

    public int Cost() {
        return cost;
    }

    public int Total() { return total; }

    public String Type() {
        return type;
    }

    public String Status() {
        return status;
    }

}