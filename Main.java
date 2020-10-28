/**
 * MyResume is simple Java App to present a Resume (CV) from command line and learn a little of that great language.
 * I hope you enjoy the journey.
 * Thanks!
 *  
 * @author      José Wuiler Pozzi <wuiler@gmail.com>
 * @version     1.0
 */
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Collection;

class Main {

	//resource for language definitions
	private static ResourceBundle resource;

	/**
	 * App Main
	 */
	public static void main(String[] args) {

		Locale chooseLanguage = new Locale("en", "US");
		Locale.setDefault(chooseLanguage);

		resource = ResourceBundle.getBundle(Constants.LANGUAGE_PATH, chooseLanguage);

		String fechaNacimientoPersona = "26/12/1978";

 		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY", chooseLanguage);
		Date fechaNacimiento = new Date();
		try{
				fechaNacimiento = sdf.parse(fechaNacimientoPersona);
		 } catch (Exception e ) {
			 
		 }

		Person persona = new Person("José Wuiler", "Pozzi", fechaNacimiento);
		persona.setAddress("Córdoba Ciudad");
		
		Collection<Skills> listaCompetencias = new ArrayList<Skills>();

		//Text keyword = new Keyword("Intro 1");
		//Print.out(keyword.get());


		Skill java = new Skill("JAVA", "Best language ever", 99.0);
		listaCompetencias.add(java);
		Skill php = new Skills("PHP", "Programming language", 95.0);
		listaCompetencias.add(php);
		Skill python = new Skills("Python", "Programming language", 50.0);
		listaCompetencias.add(python);
		Skill javascript = new Skills("Javascript", "fake", 98.9);
		listaCompetencias.add(javascript);
		Skill asp = new Skills("ASP", "Active Server Pages", 99.9);
		listaCompetencias.add(asp);

		Collection<Experience> experiencia = new ArrayList<Experience>();

		Curriculum cv = assemble(persona, listaCompetencias, experiencia, chooseLanguage);

		showCurriculum(cv, chooseLanguage);

		showMenu(cv, chooseLanguage);

	}

	/**
	 * Show the curriculum.
	 *
	 * @param persona  the Person who want to show
	 * @param language the Language we use to show de cv
	 * @return void
	 * @since 1.0
	 */
	public static void showCurriculum(Curriculum cv, Locale language) {
		cv.setLanguage(language);
		cv.loadFrom(0);
		Print.out(cv.compile());

	}

	public static void showCurriculum(Curriculum cv, Locale language, int fromUrl) {
		cv.setLanguage(language);
		cv.loadFrom(fromUrl);
		Print.out(cv.compile());

	}

	/**
	 * Build console menu and control UI
	 *
	 * @param persona  the Person who want to show
	 * @param language the Language we use to show de cv
	 * @return void
	 * @since 1.0
	 */
	public static void showMenu(Curriculum cv, Locale language) {

		Scanner choose = new Scanner(System.in);
		String choice = null;
		int fromUrl = 0;
		int x = 0;

		while (!"X".equalsIgnoreCase(choice)) {

			Print.out(resource.getString("menu.title"));
			Print.out(resource.getString("menu.item.lang.English"));
			Print.out(resource.getString("menu.item.lang.Spanish"));
			Print.out(resource.getString("menu.item.lang.German"));
			Print.out(resource.getString("menu.item.lang.Portugues"));
			Print.out(resource.getString("menu.item.lang.URL") + " [" + language.getLanguage().toUpperCase() + "]");
			Print.out(resource.getString("menu.item.lang.Inspire"));
			tP("menu.item.make.own");
			Print.out(resource.getString("menu.item.Exit"));
			Print.line(resource.getString("menu.choose.title"));
			choice = choose.nextLine();

			if ("EN".equalsIgnoreCase(choice)) {
				language = new Locale("en", "US");
				choice = null;
			}
			if ("ES".equalsIgnoreCase(choice)) {
				language = new Locale("es", "AR");
				choice = null;
			}
			if ("DE".equalsIgnoreCase(choice)) {
				language = new Locale("de", "DE");
				choice = null;
			}
			if ("BR".equalsIgnoreCase(choice)) {
				language = new Locale("pt", "BR");
				choice = null;
			}
			if ("N".equalsIgnoreCase(choice)) {
				showMenuAdmin(cv,language);
				choice = null;
			}
			if ("X".equalsIgnoreCase(choice)) {
				Print.out(inspire());
				showGoodBye();
				choice = null;
				System.exit(0);
			}

			Locale.setDefault(language);
			resource = ResourceBundle.getBundle(Constants.LANGUAGE_PATH, language);

			Print.line(Constants.ANSI_CLS + Constants.ANSI_HOME);
			System.out.flush();

			if ("I".equalsIgnoreCase(choice)) {

				Print.out(inspire());

			}

			showCurriculum(cv, language, fromUrl);

		}

		choose.close();

	}

	/**
	 * Build console menu and control UI
	 *
	 * @param persona  the Person who want to show
	 * @param language the Language we use to show de cv
	 * @return void
	 * @since 1.0
	 */
	public static void showMenuAdmin(Curriculum cv, Locale language) {

		Scanner choose = new Scanner(System.in);
		String choice = null;
		int fromUrl = 0;
		int x = 0;

		while (!"X".equalsIgnoreCase(choice)) {

			tP("menu.item.make.own");
			tP("menu.item.Exit");
			choice = choose.nextLine();

			if ("X".equalsIgnoreCase(choice)) {
				showMenu(cv,language);
				choice = null;
			}

			Locale.setDefault(language);
			resource = ResourceBundle.getBundle(Constants.LANGUAGE_PATH, language);

			Print.line(Constants.ANSI_CLS + Constants.ANSI_HOME);
			System.out.flush();

		}

		choose.close();

	}

	public static void showWelcome() {
		Print.out(resource.getString("app.welcome"));
	}

	public static void showGoodBye() {
		tP("app.bye");
		Print.out(resource.getString("app.bye"));
	}

	public static String inspire() {
		int iSize = Inspire.phrase.length;

		String phrase = "Not inspired";

		try {
			phrase = Inspire.phrase[new Random().nextInt(iSize)];
		} catch (Exception e) {
			Print.out(phrase);
		}

		return phrase;

	}

	public static Curriculum assemble(Person persona, Collection<Skills> competencias, Collection<Experience> experiencia,
			Locale language) {

		Curriculum myCv = new Curriculum(persona, competencias, experiencia, language);

		return myCv;

	}

	public static String t(String key) {
		return resource.getString(key);
	}

	public static void tP(String key) {
		Print.out(t(key));
	}
	
}

