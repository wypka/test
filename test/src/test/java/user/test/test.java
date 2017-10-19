package user.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.dto.UserDto;

public class test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoFactory.class);
		
		
		UserDao dao = context.getBean("userdao",UserDao.class);
		UserDto dto = new UserDto();
		
		dto.setUserId("child");
		dto.setUserName("wooyoung");
		dto.setUserPassword("jung");
		
		dao.add(dto);
		UserDto dto2 = dao.getUser(dto.getUserId());
		
		System.out.println("데이터 삽입 완료");
		System.out.println(dto2.getUserPassword()+" 조회 완료");
		
	}

}
