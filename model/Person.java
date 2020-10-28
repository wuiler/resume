import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {

		private String name;
		private String surname;
    private Date birthDay;
		private String address;

    public Person() {
      //default constructor
    }

    public Person(String name, String surname, Date birthDay) {
      this.name = name;
			this.surname = surname;
			this.birthDay = birthDay;
    }

    public String getName() {
      return this.name;
    }
    
    public void setName(String name) {
      this.name = name;
    }

    public String getSurname() {
      return this.surname;
    }
    
    public void setSurname(String surname) {
      this.surname = surname;
    }

    public Date getBirthDay() {
      return this.birthDay;
    }
    
    public void setBirthDay(Date birthDay) {
      this.birthDay = birthDay;
    }

    public String getAddress() {
      return this.address;
    }
    
    public void setAddress(String address) {
      this.address = address;
    }

    public String getFullName() {
      return this.name + " " + this.surname;
    }

		public int getAge() {
			LocalDate today = LocalDate.now();
			LocalDate past = Instant.ofEpochMilli(this.birthDay.getTime())
																	.atZone(ZoneId.systemDefault())
																	.toLocalDate();
			return Period.between(past, today).getYears();	
		}
  
}
