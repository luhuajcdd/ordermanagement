package com.dehua.order.read;

import java.io.FileNotFoundException;

public interface IRead {
	int read(String path) throws FileNotFoundException;
}
