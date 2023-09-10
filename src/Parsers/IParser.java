package Parsers;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IParser<T> {
    public T parseFile(String filePath) throws IOException, FileNotFoundException;
}
