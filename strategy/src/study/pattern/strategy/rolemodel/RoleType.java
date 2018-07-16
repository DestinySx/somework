package study.pattern.strategy.rolemodel;

public enum RoleType {
    ARCHER(new Archer()),
    LANCER(new Lancer()),
    SABER(new Saber());

    private Role role;

    private  RoleType(Role role){
        this.role = role;
    }

    public Role get(){ return  this.role;}
}