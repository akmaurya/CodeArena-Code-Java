package com.src.java.io.file;

import java.io.File;

public class DiskSpaceDetail {
	public static void main(String[] args) {
		File file = new File("c:" + File.separator + "temp");
		long totalSpace = file.getTotalSpace(); // total disk space in bytes.
		long freeSpace = file.getFreeSpace(); // unallocated / free disk space
												// in bytes.

		System.out.println(" === Partition Detail ===");

		System.out.println(" === bytes ===");
		System.out.println("Total size : " + totalSpace + " bytes");
		System.out.println("Space free : " + freeSpace + " bytes");

		System.out.println(" === mega bytes ===");
		System.out.println("Total size : " + totalSpace / 1024 / 1024 /1024 + " gb");
		System.out.println("Space free : " + freeSpace / 1024 / 1024 /1024 + " gb");
	}
}
