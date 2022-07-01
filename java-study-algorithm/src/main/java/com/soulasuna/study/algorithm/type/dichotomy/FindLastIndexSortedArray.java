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
import com.soulasuna.study.algorithm.type.dichotomy.input.FindLastIndexSortedArrayInput;

import java.util.Arrays;

public final class FindLastIndexSortedArray implements AlgorithmProcess<FindLastIndexSortedArrayInput, Integer> {
    
    @Override
    public Integer actualProcess(final FindLastIndexSortedArrayInput input) {
        return doProcess(input.getArray(), input.getStart(), input.getEnd(), input.getTarget());
    }
    
    private Integer doProcess(final int[] array, final int start, final int end, final int target) {
        int startIndex = start;
        int endIndex = end - 1;
        int result = -1;
        while (startIndex < endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex >> 1);
            int middleElement = array[middleIndex];
            if (target >= middleElement) {
                if (target == middleElement) {
                    result = middleIndex;
                }
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return target == array[endIndex] ? endIndex : result;
    }
    
    @Override
    public Integer expendProcess(final FindLastIndexSortedArrayInput input) {
        int[] array = input.getArray();
        int startIndex = input.getStart();
        int endIndex = input.getEnd();
        int target = input.getTarget();
        int result = -1;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (target == array[i]) {
                result = i;
            }
        }
        return result;
    }
    
    @Override
    public FindLastIndexSortedArrayInput generateInput() {
        int[] array = RandomUtil.getIntArray(20, 100);
        Arrays.sort(array);
        int startIndex = 0;
        int endIndex = array.length;
        int target = array[RandomUtil.randomInt(array.length - 1)];
        return new FindLastIndexSortedArrayInput(array, startIndex, endIndex, target);
    }
    
    @Override
    public FindLastIndexSortedArrayInput cloneInput(final FindLastIndexSortedArrayInput input) {
        int[] array = FuncUtil.cloneArray(input.getArray());
        return new FindLastIndexSortedArrayInput(array, input.getStart(), input.getEnd(), input.getTarget());
    }
    
    @Override
    public boolean isSameResult(final Integer expend, final Integer actual) {
        return expend.equals(actual);
    }
    
    @Override
    public String getName() {
        return "Find last index sorted array";
    }
}
