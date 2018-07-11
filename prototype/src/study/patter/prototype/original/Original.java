package study.patter.prototype.original;


/*
 * date 20180712
 * author suxin
 * */
public class Original implements Cloneable{

    private int id;
    private String name;
    private Desciption desciption;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Desciption getDesciption() {
        return desciption;
    }

    public void setDesciption(Desciption desciption) {
        this.desciption = desciption;
    }
}
