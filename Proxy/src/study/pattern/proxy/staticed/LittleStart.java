package study.pattern.proxy.staticed;

public class LittleStart implements Start{

    public void planOfJob(){
        System.out.println("1,Making a little movie");
        System.out.println("2.Participate in the activity");
    }

    @Override
    public void planOfMoney() {
        System.out.println("earn little money");
    }

    @Override
    public void planOfFood() {
        System.out.println("eat meats");
    }
}
