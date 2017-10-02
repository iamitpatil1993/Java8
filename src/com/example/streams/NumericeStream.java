package com.example.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NumericeStream {

	public static void main(String[] args) {
		
		try {
			
			Files.lines(Paths.get("file.txt"), Charset.defaultCharset()).forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
