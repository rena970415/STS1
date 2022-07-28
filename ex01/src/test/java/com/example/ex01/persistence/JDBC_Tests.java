package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBC_Tests {

	// 드라이버를 메모리에 올림
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 드라이버에 대한 주소

	@Test
	public void testConnection() {
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")){
			log.info(connection);
		}catch (Exception e) {
			// JUnit의 메서드로서, 무조건 실패로 처리한 뒤 실행을 중지한다.
			fail(e.getMessage());
		}
	}
}
