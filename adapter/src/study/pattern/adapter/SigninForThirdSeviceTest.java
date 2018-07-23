package study.pattern.adapter;

import study.pattern.adapter.signin.LoginForQQAdapter;

public class SigninForThirdSeviceTest {
    public static void main(String[] args) {
        LoginForQQAdapter loginForQQAdapter = new LoginForQQAdapter();

        //使用qq注册登陆
        loginForQQAdapter.rigninAndLogin("1231231232132");
    }
}
