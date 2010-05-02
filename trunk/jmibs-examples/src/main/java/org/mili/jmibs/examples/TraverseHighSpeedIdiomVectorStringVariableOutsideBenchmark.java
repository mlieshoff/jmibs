/*
 * TraverseHighSpeedIdiomVectorStringVariableOutsideBenchmark.java
 *
 * 12.04.2010
 *
 * Copyright 2010 Michael Lieshoff
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mili.jmibs.examples;

import java.util.*;

import org.mili.jmibs.impl.*;

/**
 * This class defines a benchmark to test performance while traversing an Vector of strings with
 * high-speed for idiom and out loop variable definition.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class TraverseHighSpeedIdiomVectorStringVariableOutsideBenchmark extends
        AbstractObjectLoadBenchmark<List<String>> {

    /**
     * creates a new traverse high speed vector string benchmark.
     */
    public TraverseHighSpeedIdiomVectorStringVariableOutsideBenchmark() {
        super();
        this.setName("Traverse: For(high speed idiom, variable outside) Vector<String>");
    }

    @Override
    public void execute() {
        String s = null;
        for (int i = 0, n = this.getModel().size(); i < n; i++) {
            s = this.getModel().get(i);
        }
    }

    @Override
    public void prepare() {
        this.setModel(new ArrayList<String>());
        for (int i = 0, n = this.getObjectLoad(); i < n; i++) {
            this.getModel().add(String.valueOf(i));
        }
    }

}
