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

package com.soulasuna.study.algorithm.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Random util.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomUtil {
    
    /**
     * Random int.
     *
     * @param max max
     * @return random int
     */
    public static int randomInt(final int max) {
        return (int) (max * Math.random() + 1);
    }
    
    /**
     * Get int array.
     *
     * @param size size
     * @param max max
     * @return array
     */
    public static int[] getIntArray(final int size, final int max) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomInt(max);
        }
        return result;
    }
    
    /**
     * Get unique int array.
     *
     * @param size size
     * @param max max
     * @return array
     */
    public static int[] getUniqueIntArray(final int size, final int max) {
        Set<Integer> temp = new LinkedHashSet<>();
        int index = 0;
        while (index < size) {
            int random = randomInt(max);
            if (temp.contains(random)) {
                continue;
            }
            index++;
            temp.add(random);
        }
        return FuncUtil.toArray(temp);
    }
}
