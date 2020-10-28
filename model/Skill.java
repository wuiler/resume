import java.util.List;

public class Skill {

		private String name;
		private String level;
		private Double percentage;
		private List<Keyword> keywords;

    public Skill() {
      //default constructor
    }

    public Skill(String name, String level, Double percentage) {
      this.name = name;
			this.level = level;
			this.percentage = percentage;
    }

    public String getName() {
      return this.name;
    }
    
    public void setName(String name) {
      this.name = name;
    }

    public String getLevel() {
      return this.level;
    }
    
    public void setLevel(String level) {
      this.level = level;
    }

    public Double getPercentage() {
      return this.percentage;
    }
    
    public void setPercentage(Double percentage) {
      this.percentage = percentage;
    }
  
		public List getKeywords(){
			return this.keywords;
		}

		public void setKeywords(List keywords){
			this.keywords = keywords;
		}    
}
