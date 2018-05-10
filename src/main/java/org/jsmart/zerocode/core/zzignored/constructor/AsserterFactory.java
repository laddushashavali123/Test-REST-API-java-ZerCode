package org.jsmart.zerocode.core.zzignored.constructor;

import org.jsmart.zerocode.core.engine.assertion.JsonAsserter;

public interface AsserterFactory {
    public abstract JsonAsserter getAsserter(String path, String expected);
}
