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

package com.soulasuna.study.algorithm.common.api;

/**
 * Algorithm process.
 *
 * @param <T> class type of input
 * @param <R> class type of result
 */
public interface AlgorithmProcess<T, R> {
    
    /**
     * Actual Process.
     *
     * @param input input
     * @return result
     */
    R actualProcess(T input);
    
    /**
     * Expend process.
     *
     * @param input input
     * @return result
     */
    R expendProcess(T input);
    
    /**
     * Generator input.
     *
     * @return input
     */
    T generateInput();
    
    /**
     * Clone input.
     *
     * @param input input
     * @return cloned input
     */
    T cloneInput(T input);
    
    /**
     * Is same result.
     *
     * @param expend expend
     * @param actual actual
     * @return is same or not
     */
    boolean isSameResult(R expend, R actual);
    
    /**
     * Get name.
     *
     * @return name
     */
    String getName();
}
