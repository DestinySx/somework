package study.pattern.proxy.staticed;

public class AgentMen {

    private Start start;

    public AgentMen(Start start){
        this.start = start;
    }

    public void planOfJob(){
        System.out.println("Began to show");
        start.planOfJob();
        System.out.println("job is over");
    }
}
