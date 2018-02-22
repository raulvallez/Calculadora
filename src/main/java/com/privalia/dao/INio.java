package com.privalia.dao;

import java.io.IOException;

public interface INio<T> {
	int addWithNio(T model) throws IOException;
}
