package persons;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import start.Weekday;

import org.junit.Test;

public class StudentTest {
	static private Student studi;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Weekdays[] weekdays = new Weekdays[] {Weekday.MONDAY, Weekday.SATURDAY};
		studi = new Student(111111, "1","HTW","TU","pi","Mustermann","Max",20,'m', weekdays);
	}
	
	@Test
	public void incrementSemesterTest() {
		assertEquals(2, studi.incrementSemester());
	}
	
	@Test
	public void getMatrikelNumberTest() {
		assertEquals(111111, studi.getMatrikelNumber());
	}

	@Test
	public void incrementSemesterTest() {
		assertEquals(2, studi.incrementSemester());
	}

	@Test
	public void getCourseTest() {
		assertEquals("pi", studi.getCourse() );
	}
	
	@Test
	public void getUniversityTest() {
		assertEquals("pi", studi.getUniversity() );
	}
	
	@Test
	public void getAgeTest() {
		assertEquals(20, studi.getAge());
	}
	
	@Test
	public void getSemesterTest() {
		assertEquals(1, studi.getSemester());
	}
	
	@Test
	public void getMatrikelNumberTest() {
		assertEquals(111111, studi.getMatrikelNumber());
	}
	
	@Test
	public void setDegreeTest() {
		studi.setDegree("master");
		assertEquals("master", studi.getDegree());
	}

}
