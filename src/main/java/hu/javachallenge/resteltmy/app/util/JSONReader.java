package hu.javachallenge.resteltmy.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class JSONReader {
    public static String getJSONString(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        in.close();

        return buffer.toString();
    }
}
