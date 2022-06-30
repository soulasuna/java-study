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
import com.soulasuna.study.algorithm.type.dichotomy.input.DichotomyInput;

import java.util.Arrays;

public abstract class AbstractDichotomy implements AlgorithmProcess<DichotomyInput, Integer> {
    
    @Override
    public Integer expendProcess(final DichotomyInput input) {
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
    public DichotomyInput generateInput() {
        int[] array = RandomUtil.getUniqueIntArray(20, 100);
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        int target = array[RandomUtil.randomInt(array.length - 1)];
        return new DichotomyInput(array, start, end, target);
    }
    
    @Override
    public DichotomyInput cloneInput(final DichotomyInput input) {
        int[] cloneArray = FuncUtil.cloneArray(input.getArray());
        int start = input.getStart();
        int end = input.getEnd();
        int target = input.getTarget();
        return new DichotomyInput(cloneArray, start, end, target);
    }
    
    @Override
    public boolean isSameResult(final Integer expend, final Integer actual) {
        return expend.equals(actual);
    }
}
