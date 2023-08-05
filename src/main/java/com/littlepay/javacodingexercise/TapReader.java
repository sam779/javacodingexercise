package com.littlepay.javacodingexercise;

import java.io.IOException;
import java.util.List;

public interface TapReader {
    List<Tap> readTaps() throws IOException;
}
