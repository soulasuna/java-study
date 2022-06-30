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

package com.soulasuna.study.algorithm.type.sort;

import com.soulasuna.study.algorithm.common.api.AlgorithmProcess;
import com.soulasuna.study.algorithm.common.util.FuncUtil;
import com.soulasuna.study.algorithm.common.util.RandomUtil;

import java.util.Arrays;

public abstract class AbstractSort implements AlgorithmProcess<int[], int[]> {
    
    @Override
    public int[] expendProcess(final int[] input) {
        if (isSorted(input)) {
            return input;
        }
        Arrays.sort(input);
        return input;
    }
    
    protected boolean isSorted(final int[] array) {
        return array.length < 2;
    }
    
    @Override
    public int[] cloneInput(final int[] input) {
        return FuncUtil.cloneArray(input);
    }
    
    @Override
    public int[] generateInput() {
        return RandomUtil.getIntArray(20, 100);
    }
    
    @Override
    public boolean isSameResult(final int[] expend, final int[] actual) {
        int actualLength = actual.length;
        int expendLength = expend.length;
        if (actualLength == expendLength) {
            for (int i = 0; i < actualLength; i++) {
                if (expend[i] != actual[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    protected void swap(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
