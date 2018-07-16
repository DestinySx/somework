package study.pattern.template;

import study.pattern.template.dao.MemberDao;

/*
 * time 20180716
 * author suxin
 * */
public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        memberDao.query();
    }
}
