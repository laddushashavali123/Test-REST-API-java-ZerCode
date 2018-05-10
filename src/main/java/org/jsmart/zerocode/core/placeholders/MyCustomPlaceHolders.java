package org.jsmart.zerocode.core.placeholders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class MyCustomPlaceHolders implements CustomPlaceHolders {
    @Override
    public String getPlaceHolders() {
        return "helloooo";
    }

    public List<String> getCustomTokens() {
        return Arrays.asList("MY.VALUE");
    }
}
