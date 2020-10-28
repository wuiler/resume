public class Print {

	public static void out(String text) {
		System.out.println(text);
	}

	public static void line(String text) {
		System.out.print(text);
	}

	public static void format(String text,String prefix, String sufix) {
		System.out.format(text,prefix,sufix);
	}

	public static String colours(String colours, String text, boolean reset) {

		StringBuilder val = new StringBuilder();
		val.append(colours).append(text);

		if (reset) {
			val.append(ConsoleColors.RESET);
		}

		return val.toString();

	}

public static void coloursOut(String colours, String text, boolean reset) {
		out(colours(colours,text,reset));
	}

public static void coloursLine(String colours, String text, boolean reset) {
		line(colours(colours,text,reset));
	}
}
