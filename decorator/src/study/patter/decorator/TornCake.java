package study.patter.decorator;

/*
 * time 20180723
 * author suxin
 * */
public class TornCake implements Pancake {
    @Override
    public String getDesc() {
        return "这是一个手抓饼";
    }

    @Override
    public int price() {
        return 4;
    }
}
