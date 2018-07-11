package study.patter.prototype.original;


/*
 * date 20180712
 * author suxin
 * */
public class Desciption implements Cloneable{
    public String desciption;

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
