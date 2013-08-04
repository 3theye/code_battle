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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author @nuboat
 */
public final class Q2 {

	private static final String INPUT = "/temp/q2/numbers.txt";
	private static final String OUTPUT = "/temp/q2/run_result.txt";

	public void execute() throws IOException {
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

		write(set, map);
	}

	private void write(final Set<String> set, final Map<String, Integer> map)
			throws IOException {
		final File f = new File(OUTPUT);

		try (
			final FileWriter fr = new FileWriter(f);
			final BufferedWriter br  = new BufferedWriter(fr)) {

			for (final String key : set) {
				br.write("\"");
				br.write(key);
				br.write("\", ");
				br.write(map.get(key));
				br.write("\n");
			}

		}
	}

	public static void main(final String[] args) throws Exception {
		final long start = System.currentTimeMillis();
		new Q2().execute();
		final long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

}
