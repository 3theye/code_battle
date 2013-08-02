/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thjug.battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PeerapatAsoktummarun
 */
public final class Q2 {

	final Charset charset = Charset.forName("UTF-8");

	public void execute() throws IOException {
		final long start = System.currentTimeMillis();

		final Set<String> set = new HashSet<>();
		final Map<String, Integer> map = new HashMap<>();
		
		try (final BufferedReader reader = Files.newBufferedReader(Paths.get("/home/numbers2.txt"), charset)) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (map.containsKey(line)) {
					final Integer num = map.get(line)+1;
					set.add(line);
					map.put(line, num);
				} else {
					map.put(line, 1);
				}
			}
		}

		final StringBuilder result = new StringBuilder();
		for (final String key : set) {
			result.append(key).append(": ").append(map.get(key)).append("\n");
		}

		writeSmallTextFile("/home/run_result2.txt", result.toString());
		final long end = System.currentTimeMillis();
		Logger.getLogger("Q2").log(Level.INFO, "run in {0} ms", (end-start));
	}

	private void writeSmallTextFile(final String aFileName, final String data) throws IOException {
		Files.write(Paths.get(aFileName), data.getBytes());
	}

}
