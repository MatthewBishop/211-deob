import java.util.ArrayList;

public class Interpreter {

	static int[] Interpreter_intLocals;

	static int[] Interpreter_arrayLengths = new int[5];

	static int[][] Interpreter_arrays = new int[5][5000];

	static int[] Interpreter_intStack = new int[1000];

	static String[] Interpreter_stringStack = new String[1000];

	static int Interpreter_frameDepth = 0;

	static ScriptFrame[] Interpreter_frames = new ScriptFrame[50];

	static Widget scriptDotWidget;

	static java.util.Calendar Interpreter_calendar = java.util.Calendar.getInstance();

	static final String[] Interpreter_MONTHS = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec" };

	static boolean field705 = false;

	static boolean field715 = false;

	static ArrayList field714 = new ArrayList();

	static int field712 = 0;

	static final double field713 = Math.log(2.0D);
}
