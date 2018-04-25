package assignment2.business.dto;

public class TeacherDto {
	private int teacherId;
	
	private String teacherName;

	private String teacherAddress;

	private String teacherPersonalNumericalCode;
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherPersonalNumericalCode() {
		return teacherPersonalNumericalCode;
	}

	public void setTeacherPersonalNumericalCode(String teacherPersonalNumericalCode) {
		this.teacherPersonalNumericalCode = teacherPersonalNumericalCode;
	}

	@Override
	public String toString() {
		return "TeacherDto [teacherName=" + teacherName + ", teacherAddress=" + teacherAddress
				+ ", teacherPersonalNumericalCode=" + teacherPersonalNumericalCode + "]";
	}
	
}
