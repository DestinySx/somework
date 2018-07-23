package study.patter.decorator;

/*
 * time 20180723
 * author suxin
 * */
public class DecoratotTest {
    public static void main(String[] args) {
        Pancake pancake = new TornCake();

        System.out.println(String.format("%s ￥%s", pancake.getDesc(), pancake.price()));

        pancake = new FiredEgg(pancake);
        System.out.println(String.format("%s ￥%s", pancake.getDesc(), pancake.price()));

        pancake = new Ham(pancake);
        System.out.println(String.format("%s ￥%s", pancake.getDesc(), pancake.price()));

    }
}