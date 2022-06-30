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

package com.soulasuna.study.algorithm.type.dichotomy;

import com.soulasuna.study.algorithm.type.dichotomy.input.DichotomyInput;

public final class FindTargetInSortedArray extends AbstractDichotomy {
    
    @Override
    public Integer actualProcess(final DichotomyInput input) {
        return findTarget(input.getArray(), input.getStart(), input.getEnd(), input.getTarget());
    }
    
    private Integer findTarget(final int[] array, final int start, final int end, final int target) {
        int left = start;
        int right = end;
        while (left < right) {
            int middleIndex = left + (right - left >> 1);
            int middleElement = array[middleIndex];
            if (target > middleElement) {
                left = middleIndex + 1;
            } else if (target < middleElement) {
                right = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return target == array[right] ? right : -1;
    }
    
    @Override
    public String getName() {
        return "Find target in sorted array";
    }
}
