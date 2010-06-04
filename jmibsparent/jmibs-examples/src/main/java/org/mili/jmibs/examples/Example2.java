/*
 * Example2.java
 *
 * 06.05.2010
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

import org.mili.jmibs.api.*;
import org.mili.jmibs.impl.*;

/**
 * This class shows an example use of ad hoc benchmarks.
 *
 * @author Michael Lieshoff
 * @version 1.0 06.05.2010
 * @since 1.1
 */
public class Example2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* add some benches. */
        final List<String> l = new ArrayList<String>();
        final int ol = 100;
        final AdHocObjectLoadBenchmark b1 = AdHocObjectLoadBenchmark.create(
                "ad hoc benchmark 1",
                new PrepareFunction() {
                    @Override
                    public void prepare() {
                        l.clear();
                        for (int i = 0, n = ol; i < n; i++) {
                            l.add(String.valueOf(i));
                        }
                    }
                }, new ExecuteFunction() {
                    @Override
                    public void execute() {
                        for (int i = 0, n = l.size(); i < n; i++) {
                            String s = l.get(i);
                        }
                    }
                });
        b1.setObjectLoad(ol);
        /* create the suite and run it, then display results. */
        System.out.println(DefaultIterationObjectLoadBenchmarkSuite.createAndRun("ad hoc suite",
                StringIterationObjectLoadBenchmarkSuiteResultRenderer.class,
                new Benchmark[]{b1}, new int[]{10, 100, 1000}, new int[]{10, 100, 1000}));
    }

}
