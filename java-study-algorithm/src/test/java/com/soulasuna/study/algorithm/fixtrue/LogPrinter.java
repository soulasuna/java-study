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

import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

@Slf4j
public final class LogPrinter {
    
    /**
     * Print array.
     *
     * @param array array
     */
    public static void printArray(final int[] array) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < array.length; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        printString(stringJoiner.toString());
    }
    
    /**
     * Print message.
     *
     * @param message message
     */
    public static void printString(final String message) {
        log.info(message);
    }
}
