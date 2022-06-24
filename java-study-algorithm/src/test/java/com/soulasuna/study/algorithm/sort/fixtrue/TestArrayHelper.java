/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.soulasuna.study.algorithm.sort.fixtrue;

import com.soulasuna.study.algorithm.fixtrue.FunUtil;
import com.soulasuna.study.algorithm.fixtrue.LogPrinter;
import com.soulasuna.study.algorithm.fixtrue.RandomGenerator;
import com.soulasuna.study.algorithm.fixtrue.ResultAsserter;
import com.soulasuna.study.algorithm.fixtrue.TimeLogger;
import com.soulasuna.study.algorithm.sort.ArraySort;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public final class TestArrayHelper {
    
    private final int times;
    
    private final int size;
    
    private final ArraySort target;
    
    private final String testName;
    
    public TestArrayHelper(final ArraySort target, final String testName) {
        this(target, testName, 20);
    }
    
    public TestArrayHelper(final ArraySort target, final String testName, final int size) {
        this(target, testName, size, 1000000);
    }
    
    public TestArrayHelper(final ArraySort target, final String testName, final int size, final int times) {
        this(times, size, target, testName);
    }
    
    /**
     * Loop test.
     */
    public void loopTest() {
        TimeLogger timeLogger = new TimeLogger();
        LogPrinter.printString("=====test name:[" + testName + "]==start=====");
        for (int i = 0; i < times; i++) {
            doTest();
        }
        LogPrinter.printString("=====loop time:["+ times + "]==spend time:[" + timeLogger.getSpend() + "ms]");
        LogPrinter.printString("=====test name:[" + testName + "]==success=====");
    }
    
    /**
     * Do test.
     */
    public void doTest() {
        int[] actual = RandomGenerator.getIntArray(size, 100);
        int[] expected = FunUtil.copyArray(actual);
        Arrays.sort(expected);
        target.sort(actual);
        if (!ResultAsserter.assertSame(expected, actual)) {
            throw new ErrorResultException(actual);
        }
    }
}
