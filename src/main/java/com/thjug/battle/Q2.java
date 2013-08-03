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

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 *
 * @author @nuboat
 */
public final class Q2 {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Q2.class);

	private static final String INPUT = "/temp/q2/numbers.txt";
	private static final String OUTPUT = "/temp/q2/run_result.txt";

	public void execute() throws IOException {
		final long start = System.currentTimeMillis();

		final Set<String> set = new HashSet<>();
		final Map<String, Integer> map = new HashMap<>();

		try (final BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT), StandardCharsets.UTF_8)) {
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
			result.append("\"").append(key).append("\", ").append(map.get(key)).append("\n");
		}

		writeSmallTextFile(OUTPUT, result.toString());
		final long end = System.currentTimeMillis();
		LOG.info("run in {} ms", (end-start));
	}

	private void writeSmallTextFile(final String aFileName, final String data) throws IOException {
		Files.write(Paths.get(aFileName), data.getBytes());
	}

}
