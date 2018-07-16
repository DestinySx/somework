package study.pattern.template;

import java.sql.ResultSet;

/*
 * time 20180716
 * author suxin
 * */
public interface RowMapper<T> {
    public T mapRow(ResultSet rs,int rowNum) throws Exception;;

}
