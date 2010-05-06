/*
 * StringIterationObjectLoadBenchmarkSuiteResultRenderer.java
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

package org.mili.jmibs.impl;

import java.util.*;

import org.mili.jmibs.api.*;

/**
 * This class defines a special implementation of interface BenchmarkSuiteResultRenderer that
 * renders the benchmark suite results in human readable a string representation.
 *
 * @author Michael Lieshoff
 * @version 1.1 23.04.2010
 * @since 1.0
 * @changed ML 23.04.2010 - suite name integrated in output.
 */
public class StringIterationObjectLoadBenchmarkSuiteResultRenderer implements
        BenchmarkSuiteResultRenderer<String> {

    /**
     * creates a new string iteration object load benchmark suite result renderer.
     */
    protected StringIterationObjectLoadBenchmarkSuiteResultRenderer() {
        super();
    }

    /**
     * creates a new string iteration object load benchmark suite result renderer.
     *
     * @return new string iteration object load benchmark suite result renderer.
     */
    public static StringIterationObjectLoadBenchmarkSuiteResultRenderer create() {
        return new StringIterationObjectLoadBenchmarkSuiteResultRenderer();
    }

    @Override
    public String render(BenchmarkSuiteResult bsr) {
        StringBuilder s = new StringBuilder();
        s.append(bsr.getBenchmarkSuite().getName());
        s.append("\n\nPerparation stats.\n");
        s.append(this.renderList(bsr.getPrepareResults()));
        s.append("\nExecution stats.\n");
        s.append(this.renderList(bsr.getExecuteResults()));
        return s.toString();
    }

    private String renderList(List<BenchmarkResult> lbr) {
        StringBuilder s = new StringBuilder();
        s.append(String.format(
                "|%1$-10s | %2$-10s | %3$-50s | %4$8s | %5$8s | %6$10s | %7$10s|" + "\n",
                "Iterations", "Objects", "Benchmark", "Avg (ms)", "Ttl (ms)", "Avg (ns)",
                "Ttl (ns)"));
        for (int i = 0, n = lbr.size(); i < n; i++) {
            BenchmarkResult br = lbr.get(i);
            IterationObjectLoadBenchmarkContext iolbc = (IterationObjectLoadBenchmarkContext)
                    br.getBenchmarkContext();
            Benchmark b = iolbc.getBenchmark();
            int ic = iolbc.getIteration();
            int oc = iolbc.getObjectLoad();
            s.append(String.format(
                    "|%1$-10s | %2$-10s | %3$-50s | %4$8d | %5$8d | %6$10d | %7$" + "10d|\n",
                    ic, oc, b.getName(), br.getAverageTime(), br.getTotalTime(), br
                    .getAverageTimeNanos(), br.getTotalTimeNanos()));
        }
        return s.toString();
    }

}
