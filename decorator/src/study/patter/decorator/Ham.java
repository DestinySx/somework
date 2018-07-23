package study.patter.decorator;

/*
 * time 20180723
 * author suxin
 * */
public class Ham implements Condiment{
    private Pancake pancake;

    public Ham(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "+火腿片";
    }

    @Override
    public int price() {
        return pancake.price() + 1;
    }
}
