/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thjug.battle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PeerapatAsoktummarun
 */
public final class Q1 {

	public void execute() throws IOException {
		final long start = System.currentTimeMillis();
		final String data = find().toString();
		Logger.getLogger("Q1").info(data);
		writeSmallTextFile("/home/run_result1.txt", data);
		final long end = System.currentTimeMillis();

		Logger.getLogger("Q1").log(Level.INFO, "run in {0} ms", (end-start));
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

		final List<String> data = readSmallTextFile("/home/numbers1.txt");

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

}
