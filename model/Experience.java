import java.util.Date;

public class Experience {

		private String name;
		private String description;
		private Date start;
		private Date end;

    public Experience() {
      //default constructor
    }

    public Experience(String name, String description, Date start, Date end) {
      this.name = name;
			this.description = description;
			this.start = start;
			this.end = end;
    }

    public String getName() {
      return this.name;
    }
    
    public void setName(String name) {
      this.name = name;
    }

    public String getDescription() {
      return this.description;
    }
    
    public void setDescription(String description) {
      this.description = description;
    }

    public Date getStart() {
      return this.start;
    }
    
    public void setStart(Date start) {
      this.start = start;
    }

    public Date getEnd() {
      return this.end;
    }
    
    public void setEnd(Date end) {
      this.end = end;
    }
    
}
