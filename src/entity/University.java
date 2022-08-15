package entity;

import java.io.Serializable;

public class  University  implements Serializable {


    public static final long serialVersionUID =1;
    private String name;

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
