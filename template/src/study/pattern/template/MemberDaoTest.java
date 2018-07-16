package study.pattern.template;

import study.pattern.template.dao.MemberDao;

public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        memberDao.query();
    }
}
