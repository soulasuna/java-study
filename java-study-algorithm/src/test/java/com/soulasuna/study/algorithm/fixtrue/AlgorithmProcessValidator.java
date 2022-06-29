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

package com.soulasuna.study.algorithm.fixtrue;

import com.google.gson.Gson;
import com.soulasuna.study.algorithm.common.api.AlgorithmProcess;
import com.soulasuna.study.algorithm.common.api.RandomCloner;
import com.soulasuna.study.algorithm.common.api.RandomGenerator;
import com.soulasuna.study.algorithm.common.api.ResultAsserter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Algorithm process validator.
 *
 * @param <T> class type of input
 * @param <R> class type of result
 */
@Slf4j
@NoArgsConstructor
public final class AlgorithmProcessValidator<T, R> {
    
    private final LogPrinter logPrinter = new LogPrinter();
    
    private AlgorithmProcess<T, R> algorithmProcess;
    
    private RandomGenerator<T> generator;
    
    private RandomCloner<T> cloner;
    
    private ResultAsserter<R> comparator;
    
    private int loop;
    
    @Builder(toBuilder = true)
    public AlgorithmProcessValidator(final AlgorithmProcess<T, R> algorithmProcess, final RandomGenerator<T> generator, final RandomCloner<T> cloner, final ResultAsserter<R> comparator,
                                     final int loop) {
        this.algorithmProcess = algorithmProcess;
        this.generator = generator;
        this.cloner = cloner;
        this.comparator = comparator;
        this.loop = loop;
    }
    
    /**
     * Validate.
     */
    public void validate() {
        String name = algorithmProcess.getName();
        LogPrinter logPrinter = new LogPrinter();
        logPrinter.start(name);
        for (int i = 0; i < loop; i++) {
            T input = generator.randomInput();
            R actual = algorithmProcess.actualProcess(input);
            R expend = algorithmProcess.expendProcess(cloner.clone(input));
            if (!comparator.isSame(actual, expend)) {
                logPrinter.error(name, input);
            }
        }
        logPrinter.success(name, loop);
    }
    
    private static class LogPrinter {
        
        private final TimeLogger timeLogger = new TimeLogger();
        
        private final Gson gson = new Gson();
        
        private void start(final String name) {
            log.info("====={}:start=====", name);
        }
        
        private void success(final String name, final int loop) {
            log.info("====={}:end==loop:{}==spend:{}=====", name, loop, timeLogger.spend());
        }
    
        private <T> void error(final String name, final T input) {
            log.info("====={}:error==data:{}=====", name, format(input));
        }
        
        private <T> String format(final T input) {
            return gson.toJson(input);
        }
    }
    
    private static final class TimeLogger {
        
        private final long startTimestamp = System.currentTimeMillis();
        
        /**
         * Get spend timeMillis.
         *
         * @return spend timeMillis
         */
        private long spend() {
            return System.currentTimeMillis() - startTimestamp;
        }
    }
}
