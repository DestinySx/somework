package study.pattern.template.dao;

import study.pattern.template.JDBCTemplate;
import study.pattern.template.RowMapper;
import study.pattern.template.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/*
 * time 20180716
 * author suxin
 * */
public class MemberDao {



//    public MemberDao(DataSource dataSource) {
//        super(dataSource);
//    }

    private JDBCTemplate jdbcTemplate = new JDBCTemplate(null);

    public List<?> query(){
        String sql = "";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {

            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassward(rs.getString("password"));
                return member;
            }

        }, null);
    }

/*    @Override
    public Object processResult(ResultSet rs,int rowNum) throws Exception{
        Member member = new Member();
        member.setUsername(rs.getString("username"));
        member.setPassward(rs.getString("password"));
        return member;
    }*/
}
