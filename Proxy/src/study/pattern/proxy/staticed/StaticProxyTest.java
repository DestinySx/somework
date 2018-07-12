package study.pattern.proxy.staticed;

public class StaticProxyTest {
    public static void main(String[] args) {
        AgentMen agentMen = new AgentMen(new LittleStart());
        agentMen.planOfJob();
    }
}
