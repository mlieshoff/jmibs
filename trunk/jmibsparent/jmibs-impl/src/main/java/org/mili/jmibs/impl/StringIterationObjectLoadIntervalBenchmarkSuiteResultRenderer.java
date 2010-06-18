/*
 * StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer.java
 *
 * 04.06.2010
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
 * @version 1.0 04.06.2010
 * @since 1.1
 */
public class StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer implements
        BenchmarkSuiteResultRenderer<String> {

    private final static String HEADER = "| %1$-10s | %2$-10s | %3$-10s | %4$-10s | %5$-50s | "
            + "%6$8s | %7$8s | %8$10s | %9$10s | %10$20s | %11$20s |\n";
    private final static String ENTRY = "| %1$-,10d | %2$-,10d | %3$-,10d | %4$-,10d | %5$-50s "
            + "| %6$,8d | %7$,8d | %8$,10d | %9$,10d | %10$20s | %11$20s |\n";
    private final static String ENTRY_WNS = "| %1$-,10d | %2$-,10d | %3$-,10d | %4$-,10d | "
            + "%5$-50s | %6$,8d | %7$,8d | %8$10s | %9$10s | %10$20s | %11$20s |\n";
    private final static String NL = "+------------+------------+------------+------------+----"
            + "------------------------------------------------+----------+----------+---------"
            + "---+------------+----------------------+----------------------+\n";

    /**
     * creates a new string iteration object load interval benchmark suite result renderer.
     */
    protected StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer() {
        super();
    }

    /**
     * creates a new string iteration object load interval benchmark suite result renderer.
     *
     * @return new string iteration object load interval benchmark suite result renderer.
     */
    public static StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer create() {
        return new StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer();
    }

    @Override
    public String render(BenchmarkSuiteResult bsr) {
        StringBuilder s = new StringBuilder();
        s.append(bsr.getBenchmarkSuite().getName());
        s.append("\n\nPreparation stats.\n");
        s.append(this.renderList(bsr.getPrepareResults()));
        s.append("\nExecution stats.\n");
        s.append(this.renderList(bsr.getExecuteResults()));
        s.append("\nComputer informations.\n");
        s.append(bsr.getComputerInfo());
        return s.toString();
    }

    private String renderList(List<BenchmarkResult> lbr) {
        StringBuilder s = new StringBuilder();
        s.append(NL);
        s.append(String.format(
                HEADER, "Iterations", "Objects", "Min", "Max", "Benchmark", "Avg (ms)",
                "Ttl (ms)", "Avg (ns)", "Ttl (ns)", "Mem (before) T/M/F", "Mem (after) T/M/F"));
        s.append(NL);
        for (int i = 0, n = lbr.size(); i < n; i++) {
            BenchmarkResult br = lbr.get(i);
            IterationObjectLoadIntervalBenchmarkContext<?> iolbc =
                    (IterationObjectLoadIntervalBenchmarkContext<?>) br.getBenchmarkContext();
            Benchmark b = iolbc.getBenchmark();
            int ic = iolbc.getIteration();
            Interval<?> oc = iolbc.getInterval();
            if (br.getTotalTime() == 0) {
                s.append(String.format(ENTRY, ic, iolbc.getObjectLoad(), oc.getMin(),
                        oc.getMax(), b.getName(), br.getAverageTime(), br.getTotalTime(),
                        br.getAverageTimeNanos(), br.getTotalTimeNanos(),
                        br.getMemoryInfoBefore().toString(), br.getMemoryInfoAfter()));
            } else {
                s.append(String.format(
                        ENTRY_WNS, ic, iolbc.getObjectLoad(), oc.getMin(), oc.getMax(),
                        b.getName(), br.getAverageTime(), br.getTotalTime(), "...", "...",
                        br.getMemoryInfoBefore().toString(), br.getMemoryInfoAfter()));
            }
        }
        s.append(NL);
        return s.toString();
    }

}
