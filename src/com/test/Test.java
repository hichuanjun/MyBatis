package com.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vo.Dept;

public class Test {

	public static void main(String[] args) throws IOException {
		//  1.加载xml
		String uri="conf.xml";
		Reader reader = Resources.getResourceAsReader(uri);
		//	2.创建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//	3.打开一个会话
		SqlSession ss=ssf.openSession();
		/*//	4.查询一条数据
		String sqlUrl="com.mapping.deptMapper.getDept";
		Dept dept = ss.selectOne(sqlUrl,10);
		System.out.println(dept.toString());*/
		//插入一条数据
		String sqlUrl="com.mapping.deptMapper.addDept";
		Dept dept = new Dept(99,"hechuanjun","hechuanjun");
		ss.insert(sqlUrl, dept);
		//	5.关闭会话
		ss.close();

	}

}
