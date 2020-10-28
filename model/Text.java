
public class Text {

		private String intro;
		private String knot;
		private String ending;

    public Text() {
      //default constructor
    }

    public Text(String text) {
      this.intro = text;
    }

    public Text(String intro, String knot, String ending) {
      this.intro = intro;
			this.knot = knot;
			this.ending = ending;
    }

    public String getIntro() {
      return this.intro;
    }
    
    public void setIntro(String intro) {
      this.intro = intro;
    }

    public String getKnot() {
      return this.knot;
    }
    
    public void setKnot(String knot) {
      this.knot = knot;
    }

    public String getEnding() {
      return this.ending;
    }
    
    public void setEnding(String ending) {
      this.ending = ending;
    }

		public String get() {
			StringBuilder sb = new StringBuilder();

			String intro = getIntro();
			String knot = getKnot();
			String end = getEnding();
			
			if (intro!=null) {
				sb.append(intro).append(" ");
			}
			if (knot!=null) {
				sb.append(knot).append(" ");;
			}
			if (end!=null) {
				sb.append(end);
			}

			return sb.toString(); 
		}
    
}
