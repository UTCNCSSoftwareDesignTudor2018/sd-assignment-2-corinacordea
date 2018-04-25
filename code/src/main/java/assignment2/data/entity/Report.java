package assignment2.data.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Report{
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
		@Field("Student Name")
		private String studentName;
		@Field("Student Group")
		private String studentGroup;
		@Field("Course Id")
		private String courseId;
		@Field("Course Name")
		private String courseName;

		public Report() {
		}
		 @PersistenceConstructor
		public Report(String studentName, String studentGroup, String courseId, String courseName) {
			super();
			this.studentName = studentName;
			this.studentGroup = studentGroup;
			this.courseId = courseId;
			this.courseName = courseName;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getStudentGroup() {
			return studentGroup;
		}

		public void setStudentGroup(String studentGroup) {
			this.studentGroup = studentGroup;
		}

		public String getCourseId() {
			return courseId;
		}

		public void setCourseId(String courseId) {
			this.courseId = courseId;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}


		public static class ReportBuilder {

			private String studentName;
			private String studentGroup;
			private String courseId;
			private String courseName;
			
			public ReportBuilder studentName(String studentName)
			{
				this.studentName = studentName;
				return this;
			}
			
			public ReportBuilder studentGroup(String studentGroup)
			{
				this.studentGroup = studentGroup;
				return this;
			}

			public ReportBuilder courseId(String courseId)
			{
				this.courseId = courseId;
				return this;
			}
			
			public ReportBuilder courseName(String courseName)
			{
				this.courseName = courseName;
				return this;
			}
			
			public Report create()
			{
				return new Report(studentName,studentGroup,courseId,courseName);
			}

		}

}
