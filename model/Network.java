import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Network {

		private String name;
		private String username;
		private String url;


    public Network() {
      //default constructor
    }

    public Network(String name, String username, String url) {
      this.name = name;
			this.username = username;
			this.url = url;
    }

    public String getName() {
      return this.name;
    }
    
    public void setName(String name) {
      this.name = name;
    }

    public String getUsername() {
      return this.username;
    }
    
    public void setUsername(String username) {
      this.username = username;
    }

		public String getUrl() {
      return this.url;
    }
    
    public void setUrl(String url) {
      this.url = url;
    }

}