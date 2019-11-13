package com.lesson.alibaba.fescar.quickstart;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.mysql.cj.jdbc.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhengshijun
 * @version created on 2019/3/4.
 */
public class FescarQuickstartBootstrap {

	public static void main(String[] args) throws SQLException {


		MysqlXADataSource dataSourceOne = getDataSource("jdbc:mysql://0.0.0.0:3306/test1", "root", "123456");


		MysqlXADataSource dataSourceTwo = getDataSource("jdbc:mysql://0.0.0.0:3306/test1", "root", "123456");


		XAConnection xaConnectionOne = dataSourceOne.getXAConnection();
		Connection connectionOne = xaConnectionOne.getConnection();

		XAResource xaResourceOne = xaConnectionOne.getXAResource();
		Statement statementOne = connectionOne.createStatement();


		XAConnection xaConnectionTwo = dataSourceTwo.getXAConnection();
		Connection connectionTwo = xaConnectionTwo.getConnection();

		XAResource xaResourceTwo = xaConnectionTwo.getXAResource();
		Statement statementTwo = connectionTwo.createStatement();


		Xid xidOne = new MysqlXid(new byte[]{0x01}, new byte[]{0x02}, 100);

		Xid xidTwo = new MysqlXid(new byte[]{0x011}, new byte[]{0x012}, 100);


		try {
			xaResourceOne.start(xidOne, XAResource.TMNOFLAGS);
			int updateOneResult = statementOne.executeUpdate("UPDATE flow_record SET sum=sum + 50 WHERE `id` = 2 for  ");
			xaResourceOne.end(xidOne, XAResource.TMSUCCESS);


			xaResourceTwo.start(xidTwo, XAResource.TMNOFLAGS);
			int updateTwoResult = statementTwo.executeUpdate("UPDATE temp1 SET s=55555 WHERE `uid` = 8");
			xaResourceTwo.end(xidTwo, XAResource.TMSUCCESS);


			int retOne = xaResourceOne.prepare(xidOne);
			int retTwo = xaResourceTwo.prepare(xidTwo);


			// 两阶段提交协议第二阶段
			if (XAResource.XA_OK == retOne && XAResource.XA_OK == retTwo) {
				xaResourceOne.commit(xidOne, false);
				xaResourceTwo.commit(xidTwo, false);

				System.out.println("reslut1:" + updateOneResult + ", result2:" + updateTwoResult);
			}

		} catch (XAException e) {
			e.printStackTrace();
		}


	}


	private static MysqlXADataSource getDataSource(String url, String username, String password) {


		MysqlXADataSource ds = new MysqlXADataSource();
		ds.setUrl(url);
		ds.setUser(username);
		ds.setPassword(password);
		return ds;
	}
}
