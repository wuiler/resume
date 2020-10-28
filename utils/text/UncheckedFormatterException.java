package utils.text;

/**
 * Created by andreinicolinciobanu on 30/03/17.
 */
public class UncheckedFormatterException extends RuntimeException {

    private static final String INVALID_NUMBER_OF_ARGUMENTS =
            "Invalid number of arguments: #{argsNum}. Every argument needs to have a pair.";

    private static final String ARGUMENT_ALREADY_DEFINED =
            "Argument '#{arg}' is already defined in the arguments list.";

    private static final String INVALID_CHARACTER_IN_PARAM_NAME =
            "Invalid character '#{char}' used in param name (affected index: #{idx}).";

    private static final String IO_EXCEPTION_READING_FROM_FILE =
            "Error accessing #{strPath}. Exception:";

    private static final String INVALID_ARGUMENT_NAME_NULL_OR_EMPTY =
            "Invalid argument name: '#{arg}'. Argument should not be null or empty";

    private static final String INVALID_STATE_EXCEPTION =
            "Invalid state: '#{state}'. No code coverage for this new state.";

    public static final String INVALID_POSITIONAL_ARGUMENT =
            "Currently there is no positional argument with: '#{index}'. Check you have enough parameters supplied through the 'posArgs(...)' method.";

    public static final String INVALID_POSITIONAL_ARGUMENTS =
            "Calling 'posArgs()' with null (or no arguments) is not accepted.";

    public UncheckedFormatterException() {
        super();
    }
    public UncheckedFormatterException(String message) {
        super(message);
    }
    public UncheckedFormatterException(String message, Throwable cause) {
        super(message, cause);
    }
    public UncheckedFormatterException(Throwable cause) { super(cause);}

    public static UncheckedFormatterException invalidPositionalArguments() {
        return new UncheckedFormatterException(INVALID_POSITIONAL_ARGUMENTS);
    }

    public static UncheckedFormatterException invalidNumberOfArguments(int argsNum) {
        String msg = AlephFormatter.str(INVALID_NUMBER_OF_ARGUMENTS).arg("argsNum", argsNum).fmt();
        return new UncheckedFormatterException(msg);
    }

    public static UncheckedFormatterException argumentAlreadyExist(String arg) {
        String msg = AlephFormatter.str(ARGUMENT_ALREADY_DEFINED).arg("arg", arg).fmt();
        return new UncheckedFormatterException(msg);
    }

    public static UncheckedFormatterException invalidCharacterInParam(char c, int idx) {
        String msg = AlephFormatter.str(INVALID_CHARACTER_IN_PARAM_NAME).args("char", c, "idx", idx).fmt();
        return new UncheckedFormatterException(msg);
    }

    public static UncheckedFormatterException ioExceptionReadingFromFile(String strPath, Throwable t) {
        String msg = AlephFormatter.str(IO_EXCEPTION_READING_FROM_FILE).arg("strPath", strPath)
                        .fmt();
        return new UncheckedFormatterException(msg, t);
    }

    public static UncheckedFormatterException invalidArgumentName(Object argName) {
        String msg = AlephFormatter.str(INVALID_ARGUMENT_NAME_NULL_OR_EMPTY, "arg", argName)
                        .fmt();
        return new UncheckedFormatterException(msg);
    }

    public static UncheckedFormatterException invalidStateException(AlephFormatter.State state) {
        String msg = AlephFormatter.str(INVALID_STATE_EXCEPTION, "state", state)
                        .fmt();
        return new UncheckedFormatterException(msg);
    }

    public static UncheckedFormatterException invalidPositionalArgumentValue(Integer index) {
        String msg = AlephFormatter.str(INVALID_POSITIONAL_ARGUMENT, "index", index)
                        .fmt();
        return new UncheckedFormatterException(msg);
    }
}
