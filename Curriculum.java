import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static utils.text.AlephFormatter.str;

public class Curriculum {

	private Person persona;
	private Collection<Skill> competencias;
	private Collection<Experience> experiencia;
	private Locale language;
	private ResourceBundle rb; 
	private int loadFrom = 0;

	public Curriculum() {
	}

	public Curriculum(Person person) {
		this.persona = person;
		this.language = Constants.LOCALEDEFAULT;
	}

	public Curriculum(Person person, Collection<Skills> competencias, Collection<Experience> experiencia, Locale locale) {
		this.persona = person;
		this.competencias = competencias;
		this.experiencia = experiencia;
		this.language = locale;
		this.rb = ResourceBundle.getBundle(Constants.LANGUAGE_PATH, locale);
	}


	public Curriculum(Person person, Locale locale) {
		this.persona = person;
		this.language = locale;
		this.rb = ResourceBundle.getBundle(Constants.LANGUAGE_PATH, locale);
	}

	public String compile() {
		StringBuilder sb = new StringBuilder();
		String fileName = Constants.CVBASEFILENAME;
		String path = Constants.CVBASEDATA;


/*		
		 // Build map
 Map<String, String> valuesMap = new HashMap<>();
 valuesMap.put("animal", "quick brown fox");
 valuesMap.put("target", "lazy dog");
 String templateString = "The ${animal} jumped over the ${target}.";

 // Build StringSubstitutor
 
 org.apache.commons.text.StringSubstitutor sub = new org.apache.commons.text.StringSubstitutor(valuesMap);

 // Replace
 String resolvedString = sub.replace(templateString);
 sb.append(resolvedString);
*/
		if (persona!=null) {

			String selectedLanguage = this.language.toString();
			if (selectedLanguage!=null ) {
				String fileNameLanguage = "_"+selectedLanguage+".md";
				fileName = Constants.CVBASEFILENAME.replace(".md",fileNameLanguage);
			}

			if (loadFrom == 0) {
				path = path + fileName;
			} else {
				path = Constants.BASEURL + fileName;
			}

			String content = null;
			try {
				if (loadFrom == 0) {
					content = utils.File.read(path);
				} else {
					content = utils.File.readUrl(path);
				}
				
			} catch(IOException ioe) {
				String msgErrorFile = rb.getString("file.error.notdefine");
				String msgErrorFileDefault = rb.getString("file.error.usingdefault");
				sb.append(MessageFormat.format(msgErrorFile, path)).append(MessageFormat.format(msgErrorFileDefault, Constants.CVBASEFILENAMEDEFAULT));
			}

			if (content==null) {
				path = fileName;
				Print.out(path);
				try {
					content = utils.File.read(path);
				} catch(IOException ioe) {
					Print.out(rb.getString("file.error.read.cannot"));	
				}
			}

			sb.append("\n\n").append(rb.getString("app.file")).append(path).append("\n");
			
			String name = Print.colours(ConsoleColors.GREEN_BOLD, persona.getFullName(), true);
			String age = Print.colours(ConsoleColors.BLUE, String.valueOf(persona.getAge()), true);
			String city = Print.colours(ConsoleColors.BLUE, persona.getAddress(), true);
			//String message = String.format(content, name, age, city); 


			String message = str(content)
				.args("nombre",name)
				.args("edad",age)
				.args("ciudad",city)
				.args("persona",persona)
				.style(utils.text.AlephFormatter.Styles.DOLLARS).fmt();
					

			sb.append(message);

		} else {
			sb.append(rb.getString("noperson"));
		}

		for(Skills skill : getSkills()) {
			//Print.out(skill.getName() + "\t\t" + skill.getPercentage());
		}

		return sb.toString();

	}

	public int loadFrom() {
		return this.loadFrom;
	}

	public void loadFrom(int from) {
		this.loadFrom = from;
	}

	public Collection<Skills> getSkills() {
		return this.competencias;
	}

	public void setSkills(Collection<Skills> competencias) {
		this.competencias = competencias;
	}

	public Collection<Experience> getExperience() {
		return this.experiencia;
	}

	public void setExperience(Collection<Experience> experiencia) {
		this.experiencia = experiencia;
	}

	public Locale getLanguage() {
		return this.language;
	}

	public void setLanguage(Locale language) {
		this.language = language;
	}

}