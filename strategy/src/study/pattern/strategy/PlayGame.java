package study.pattern.strategy;

import study.pattern.strategy.rolemodel.RoleType;

public class PlayGame {

//    private static Map<String,Object> list = new HashMap<String,Object>();
//
//    public PlayGame(){
//        list.put("Saber",new Saber());
//        list.put("Lancer",new Lancer());
//        list.put("Archer",new Archer());
//    }
//
//    public Role chooseRole(String name,Map<String,Object> list){
//        return  (Role)list.get(name);
//    }

    public static void main(String[] args) {
        System.out.println("choose your role");
        RoleType.ARCHER.get().getRole();
        System.out.println("Game start");
    }

}
