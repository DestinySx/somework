package study.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
* time 20180716
* author suxin
* */
public class JDBCTemplate {

    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws  Exception{
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection conn,String sql) throws  Exception{
        return  conn.prepareStatement(sql);
    }


    private ResultSet executeQuery(PreparedStatement pstmt,Object [] values) throws  Exception{
        for (int i = 0; i <values.length; i ++){
            pstmt.setObject(i,values[i]);
        }
        return  pstmt.executeQuery();
    }

    private void closeStatement(Statement stmt) throws  Exception{
        stmt.close();
    }

    private void closeResultSet(ResultSet rs) throws  Exception{
        rs.close();
    }

    private void closeConnection(Connection conn) throws  Exception{
        //通常把它放到连接池回收
    }

    private List<?> parseResultSet(ResultSet rs,RowMapper rowMapper) throws  Exception{
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            //mapRow 这个方法实现是否是MemberDao类中
            result.add(rowMapper.mapRow(rs,rowNum ++));
        }
        return result;
    }


    public List<?> executeQuery(String sql, RowMapper<?> rowMapper,Object[] values) {

        try{
            // 1.获取链接
            Connection conn = this.getConnection();
            // 2.生成sql语句
            PreparedStatement pstmt =  this.createPreparedStatement(conn,sql);
            // 3.执行语句集。获取结果集
            ResultSet  rs = this.executeQuery(pstmt,values);
            // 4.解析结果集
            List<?> result = this.parseResultSet(rs,rowMapper);
            // 5.关闭结果集
            this.closeResultSet(rs);
            // 6.关闭语句集
            this.closeStatement(pstmt);
            // 7.关闭链接
            this.closeConnection(conn);

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    public abstract Object processResult(ResultSet rs,int rowNum)throws Exception;

}
