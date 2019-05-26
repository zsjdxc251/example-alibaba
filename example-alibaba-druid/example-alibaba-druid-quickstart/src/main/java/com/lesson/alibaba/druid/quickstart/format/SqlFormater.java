package com.lesson.alibaba.druid.quickstart.format;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;

/**
 * @author zhengshijun
 * @version created on 2019/5/26.
 */
public class SqlFormater {


    /**
     * 格式化SQL操作
     *
     * @param sql
     * @return
     */
    public static String sqlFormat(String sql) {

        System.out.println( SQLUtils.formatMySql(sql));
        // 查询的SQL以及对应的SQL类型
        String result = SQLUtils.format(sql, JdbcConstants.MYSQL);
        // 查询的SQL以及对应的SQL类型以及具体大小写
        String resultLCase = SQLUtils.format(result
                , JdbcConstants.MYSQL_DRIVER
                , SQLUtils.DEFAULT_FORMAT_OPTION);
        return resultLCase;
    }


    public static void main(String[] args) {
        System.out.println(sqlFormat("select a.id,b.name,age from t_table a left join t_b b on b.id=c.id where id=#{id} order by create_time desc limit 1,10"));
    }

}
