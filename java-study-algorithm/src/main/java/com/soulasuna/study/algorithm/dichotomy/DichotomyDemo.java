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

package com.soulasuna.study.algorithm.dichotomy;

public final class DichotomyDemo {
    
    /**
     * Find target.
     *
     * @param array array
     * @param target target
     * @param left left
     * @param right right
     * @return find index
     */
    public static int findTarget(final int[] array, final int target, final int left, final int right) {
        int startIndex = left;
        int endIndex = right;
        while (startIndex < endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex >> 1);
            int middle = array[middleIndex];
            if (target > middle) {
                startIndex = middleIndex + 1;
            } else if (target < middle) {
                endIndex = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return array[startIndex] == target ? startIndex : -1;
    }
}
