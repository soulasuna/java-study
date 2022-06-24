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

package com.soulasuna.study.algorithm.sort;

import com.soulasuna.study.algorithm.sort.fixtrue.TestArrayHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public final class ArraySortTest {
    
    @Test
    public void assertBubbleSort() {
        new TestArrayHelper(new BubbleSort(), "bubble sort").loopTest();
    }
    
    @Test
    public void assertSelectionSort() {
        new TestArrayHelper(new SelectionSort(), "selection sort").loopTest();
    }
    
    @Test
    public void assertInsertionSort() {
        new TestArrayHelper(new InsertionSort(), "insertion sort").loopTest();
    }
}
