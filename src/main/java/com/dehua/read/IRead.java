package com.dehua.read;

import java.io.FileNotFoundException;

public interface IRead {
	int read(String path) throws FileNotFoundException;
}
