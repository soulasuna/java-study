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

import com.soulasuna.study.algorithm.fixtrue.AlgorithmProcessValidator;
import com.soulasuna.study.algorithm.type.dichotomy.input.DichotomyInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class DichotomyTest {
    
    @Test
    public void assertProcess() {
        FindTargetInSortedArray findTargetInSortedArray = new FindTargetInSortedArray();
        assertTrue(new AlgorithmProcessValidator<DichotomyInput, Integer>().toBuilder().process(findTargetInSortedArray).loop(100000).build().validate());
    }
}