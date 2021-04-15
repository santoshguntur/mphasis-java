package test;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.college.entity.Room;
import com.college.entity.User;
import com.college.util.HibernateUtil;
import com.google.gson.Gson;

public class HibernateTest {

	private static SessionFactory sessionFacory;
	private static Session session;

	@BeforeAll
	public static void setup() {
		System.out.println("Starting the sessionFacory");
		sessionFacory = HibernateUtil.getSessionFactory();
		System.out.println("sessionFacory created:" + sessionFacory);
	}

	@AfterAll
	public static void tearDown() {

		sessionFacory.close();
		System.out.println("sessionOne destroyed");
	}

	@BeforeEach
	public void testCaseSetup() {

		session = sessionFacory.openSession();
		session.beginTransaction();
		System.out.println("session created:" + session);
	}

	@AfterEach
	public void testCaseTearDown() {

		session.getTransaction().commit();
		session.close();
		System.out.println("session closed:");
	}

	@Test
	public void UserTest() {

		User user = new User();

		user.setFirstName("Santosh");
		user.setLastName("Guntur");
		user.setEmilId("santosh.0526@gmail.com");
		user.setPassword("santosh");
		user.setRole("U");
		user.setAddress("First Line" + System.lineSeparator() + "Second Line" + System.lineSeparator() + "ZIPCODE");
		Integer id = (Integer) session.save(user);

		Assertions.assertTrue(id > 0);

	}

	@Test
	public void RoomTest() {

		Room room = new Room("DELUX", "First Line " + "Second Line " + "ZIPCODE", new BigDecimal(100.5), "AVILABLE",
				"NOTPAID");
		Integer id = 0;
		id = (Integer) session.save(room);

		Assertions.assertTrue(id > 0);

	}
	@Test
	public void userRoomUpdateTest() {

		User user=session.get(User.class, 1);
		Room room=session.get(Room.class, 1);
		System.out.println(user);
		System.out.println(room);
		user.setRoom(room);
		session.saveOrUpdate(user);
		user=session.get(User.class, 1);
		room=session.get(Room.class, 1);
		System.out.println(user);
		System.out.println(new Gson().toJson(user));
		System.out.println(room);
		System.out.println(new Gson().toJson(room));
		Assertions.assertTrue(null==null);

	}

}
