package com.idref.other;

import java.io.InputStream;

import org.apache.log4j.Logger;

public final class Files {

	private final static Logger logger = Logger.getLogger(Files.class);

	public static InputStream getFile(String mainPath, String file) {
		final String pathname = (mainPath == null ? file : mainPath + file);
		InputStream stream = Files.class.getResourceAsStream(pathname);
		if (stream == null) {
			logger.error("Can't read file: " + pathname);
		}
		return stream;
	}

}
