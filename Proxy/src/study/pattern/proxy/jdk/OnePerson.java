package study.pattern.proxy.jdk;

public class OnePerson implements Person {

    public void findLove(){
        System.out.println("白富美");
        System.out.println("身高160cm");
        System.out.println("轻音体柔");
    }

    @Override
    public void zufangzi() {
        System.out.println("租房子");
    }

    @Override
    public void buy() {
        System.out.println("买东西");
    }

    @Override
    public void findJob() {
        System.out.println("月薪20K-50k");
        System.out.println("找工作");
    }

}
