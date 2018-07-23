package study.pattern.adapter.signin;

/*
 * time 20180717
 * author suxin
 * */
public class LoginForQQAdapter {

    private SigninService signinService;

    /*注册*/
    public void rigninAndLogin(String PID) {
        System.out.println("使用QQ注册账号");
        signinService = new SigninService();
        String username = PID;
        String password = "QQ_PID";
        signinService.rignin(username,password);
        signinService.login(username,password);

    }
}
