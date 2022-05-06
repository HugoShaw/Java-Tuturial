package support.cse131;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Scanners {
	public static ArgsProcessor createArgsProcessorFromScanner(Scanner scanner) {
		List<String> list = new LinkedList<>();
		try {
			while (scanner.hasNext()) {
				String s = scanner.next();
				list.add(s);
			}
		} finally {
			scanner.close();
		}
		String[] argsForArgsProcessor = list.toArray(new String[list.size()]);
		return new ArgsProcessor(argsForArgsProcessor);
	}

	public static ArgsProcessor createArgsProcessorFromFile(File file) throws FileNotFoundException {
		return createArgsProcessorFromScanner(new Scanner(file));
	}
}
