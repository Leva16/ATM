package com.exercise.atm;

import java.io.IOException;
import java.util.Map;

public interface PropertiesFile {

    Map getPropValues() throws IOException;
    void setPropValues(final Map<Integer, Integer> setProp) throws IOException;
}
