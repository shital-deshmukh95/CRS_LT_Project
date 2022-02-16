package com.crs.lt.constant;

public class SQLQueryConstant {

	public static final String CHECK_CREDENTIALS_USER_DETAILS = "select password from user where userId = ?";
	public static final String GET_ROLE_TYPE ="select roleType from role where userId = ?";
	public static final String ADD_COURSE_FOR_STUDENT ="insert into registeredcourse (studentId,courseCode,grade) values ( ? , ?, ?)";
	public static final String DECREMENT_AVAILABLE_SEATS ="update course set availableSeats = availableSeats-1 where courseCode = ?";
	public static final String SET_REGISTRATION_STATUS ="update student set isRegistered = true  where studentId=?";
	public static final String GET_REGISTRATION_STATUS ="select isRegistered from student where studentId = ?";
	public static final String GET_PAYMENT_STATUS="select isPaid from student where studentId = ?";
	public static final String VIEW_REGISTRATION_COURSE="select * from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?";
	public static final String VIEW_COURSE ="select * from course where courseCode not in  (select courseCode  from registeredcourse where studentId = ?) and availableSeats > 0";
	public static final String DROP_COURSE="delete from registeredcourse where courseCode = ? AND studentId = ?";
	public static final String INCREMENT_AVAILABLE_SEATS ="update course set availableSeats = availableSeats + 1 where  courseCode = ?";
	public static final String GET_ENROLLED_STUDENT ="select course.courseCode,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.instructorId = ? order by course.courseCode";
	public static final String VIEW_COURSE_CATALOG ="select courseCode, courseName, description from Catalog";
	public static final String DELETE_COURSE_FROM_CATALOG = "delete from Course where courseCode = ?";
	public static final String ADD_COURSE_CATALOG ="insert into Course(courseCode, courseName, availableSeats, instructorId) values (?, ?, ?, ?)";
	public static final String ADD_GRADE="update registeredcourse set grade=? where courseCode=? and studentId=?";
}
