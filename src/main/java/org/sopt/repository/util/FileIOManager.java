package org.sopt.repository.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOManager {
	private static final Path FILE_PATH = Paths.get("src/main/java/org/sopt/assets/member.txt");

	public static ObjectOutputStream openObjectWriter() throws IOException {
		if (!Files.exists(FILE_PATH)) {
			Files.createFile(FILE_PATH);
		}
		return new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(FILE_PATH)));
	}

	public static boolean isFileEmpty() throws IOException {
		return !Files.exists(FILE_PATH) || Files.size(FILE_PATH) == 0;
	}

	public static ObjectInputStream openObjectReader() throws IOException {
		if (isFileEmpty()) {
			return null;
		}
		return new ObjectInputStream(new BufferedInputStream(Files.newInputStream(FILE_PATH)));
	}
}
