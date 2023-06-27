package com.src.java.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Delete files using FilenameFilter Interface
 * @author GPS
 *
 */
public class DeleteFiles {
	private static final String FILE_DIR = ".";
	private static final String FILE_TEXT_EXT = ".txt";

	public static void main(String args[]) {
		new DeleteFiles().deleteFile(FILE_DIR, FILE_TEXT_EXT);
	}

	// Inner class
	private void deleteFile(String folder, String ext) {
		GenericExtFilter filter = new GenericExtFilter(ext);
		File dir = new File(folder);

		// list out all the file name with .txt extension
		String[] list = dir.list(filter);

		if (list.length == 0) {
			return;
		}

		File fileDelete;

		for (String file : list) {
			String temp = new StringBuffer(FILE_DIR).append(File.separator).append(file).toString();
			fileDelete = new File(temp);
			boolean isdeleted = fileDelete.delete();
			System.out.println("file : " + temp + " is deleted : " + isdeleted);
		}
	}
	
	private class GenericExtFilter implements FilenameFilter {
		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		@Override
		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}
}
