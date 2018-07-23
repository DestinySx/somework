package study.patter.decorator;

/*
 * time 20180723
 * author suxin
 * */
public class FiredEgg implements Condiment {

    private Pancake pancake;

    public FiredEgg(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getDesc() {
        return pancake.getDesc() + "+煎蛋";
    }

    @Override
    public int price() {
        return pancake.price() + 2;
    }
}
