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

import com.soulasuna.study.algorithm.common.api.AlgorithmProcess;
import com.soulasuna.study.algorithm.common.util.FuncUtil;
import com.soulasuna.study.algorithm.common.util.RandomUtil;
import com.soulasuna.study.algorithm.type.dichotomy.input.FindTargetInSortedArrayInput;

import java.util.Arrays;

public final class FindTargetInSortedArray implements AlgorithmProcess<FindTargetInSortedArrayInput, Integer> {
    
    @Override
    public Integer actualProcess(final FindTargetInSortedArrayInput input) {
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
    public Integer expendProcess(final FindTargetInSortedArrayInput input) {
        int[] array = input.getArray();
        int start = input.getStart();
        int end = input.getEnd();
        int target = input.getTarget();
        for (int i = start; i <= end; i++) {
            if (target == array[i]) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public FindTargetInSortedArrayInput generateInput() {
        int[] array = RandomUtil.getUniqueIntArray(20, 100);
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        int target = array[RandomUtil.randomInt(array.length - 1)];
        return new FindTargetInSortedArrayInput(array, start, end, target);
    }
    
    @Override
    public FindTargetInSortedArrayInput cloneInput(final FindTargetInSortedArrayInput input) {
        int[] cloneArray = FuncUtil.cloneArray(input.getArray());
        int start = input.getStart();
        int end = input.getEnd();
        int target = input.getTarget();
        return new FindTargetInSortedArrayInput(cloneArray, start, end, target);
    }
    
    @Override
    public boolean isSameResult(final Integer expend, final Integer actual) {
        return expend.equals(actual);
    }
    
    @Override
    public String getName() {
        return "Find target in sorted array";
    }
}
