package study.pattern.strategy.rolemodel;


public class Archer implements Role{

    @Override
    public void getRole() {
        System.out.println("This is Archer");
    }
}
