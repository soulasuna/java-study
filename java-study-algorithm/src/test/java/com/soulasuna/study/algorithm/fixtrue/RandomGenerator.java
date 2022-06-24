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

import java.util.LinkedHashSet;
import java.util.Set;

public final class RandomGenerator {
    
    public static int[] getIntArray(final int size) {
        return getIntArray(size, Integer.MAX_VALUE);
    }
    
    public static int[] getIntArray(final int size, final int max) {
        return getIntArray(size, max, false);
    }
    
    public static int[] getIntArray(final int size, final int max, final boolean unique) {
        if (unique) {
            return getUniqueIntArray(size, max);
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = getInt(max);
        }
        return result;
    }
    
    public static int getInt(int max) {
        return (int) (max * Math.random() + 1);
    }
    
    private static int[] getUniqueIntArray(final int size, final int max) {
        Set<Integer> temp = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            int random = getInt(max);
            if (temp.contains(random)) {
                i--;
                continue;
            }
            temp.add(random);
        }
        return FunUtil.toArray(temp);
    }
}
