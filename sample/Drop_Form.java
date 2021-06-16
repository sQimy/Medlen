package sample;

import com.mysql.cj.conf.IntegerProperty;

import java.io.Serializable;

class Drop_Form implements Serializable {

    private static final long serialVersionUID = 1L;

    private Object cost;
    private Object total;
    private Object type;
    private Object status;


    public Drop_Form(Object cost, Object total, Object type, Object status)
    {
        this.cost = cost;
        this.total = total;
        this.type  = type;
        this.status = status;
    }

    public Object Cost() { return cost; }

    public Object Total() { return total;}

    public Object Type() { return type;}

    public Object Status() { return status; }


}