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

import java.util.Collection;
import java.util.Iterator;

public final class FuncUtil {
    
    /**
     * To array.
     *
     * @param collection collection
     * @return array
     */
    public static int[] toArray(final Collection<Integer> collection) {
        int size = collection.size();
        int[] result = new int[size];
        int index = 0;
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            index++;
        }
        return result;
    }
}
