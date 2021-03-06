/*
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 */
package com.thjug.battle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author @nuboat
 */
public final class Q1 {

	private static final String INPUT = "/temp/q1/numbers.txt";
	private static final String OUTPUT = "/temp/q1/run_result.txt";

	public void execute() throws IOException {
		final StringBuilder result = new StringBuilder();
		for (final Integer d : find()) {
			result.append(d).append("\n");
		}

		writeSmallTextFile(OUTPUT, result.toString());
	}

	private List<String> readSmallTextFile(final String aFileName) throws IOException {
		final List<String> result = Files.readAllLines(Paths.get(aFileName), StandardCharsets.UTF_8);
		Collections.sort(result);
		return result;
	}

	private void writeSmallTextFile(final String aFileName, final String data) throws IOException {
		Files.write(Paths.get(aFileName), data.getBytes());
	}

	private List<Integer> find() throws IOException {

		final List<String> data = readSmallTextFile(INPUT);

		final List<Integer> result = new LinkedList();

		for (int i = 0; i < (data.size()-1); i++) {
			final int first = Integer.parseInt(data.get(i));
			final int second = Integer.parseInt(data.get(i+1));
			if ((second-first) != 1) {
				result.add(first+1);
			}
		}

		return result;
	}

	public static void main(final String[] args) throws Exception {
		final long start = System.currentTimeMillis();
		new Q1().execute();
		final long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

}
