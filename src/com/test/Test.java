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
		//  1.����xml
		String uri="conf.xml";
		Reader reader = Resources.getResourceAsReader(uri);
		//	2.����SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//	3.��һ���Ự
		SqlSession ss=ssf.openSession();
		/*//	4.��ѯһ������
		String sqlUrl="com.mapping.deptMapper.getDept";
		Dept dept = ss.selectOne(sqlUrl,10);
		System.out.println(dept.toString());*/
		//����һ������
		String sqlUrl="com.mapping.deptMapper.addDept";
		Dept dept = new Dept(99,"hechuanjun","hechuanjun");
		ss.insert(sqlUrl, dept);
		//	5.�رջỰ
		ss.close();

	}

}
