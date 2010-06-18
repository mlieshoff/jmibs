/*
 * Example2.java
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

package org.mili.jmibs.jfree.examples;

import java.awt.*;
import java.util.*;
import java.util.List;

import org.jfree.chart.*;
import org.jfree.ui.*;
import org.mili.jmibs.api.*;
import org.mili.jmibs.examples.*;
import org.mili.jmibs.impl.*;
import org.mili.jmibs.jfree.*;

/**
 * This class shows an example use of jFreeChart application.
 *
 * @author Michael Lieshoff
 * @version 1.1 17.06.2010
 * @since 1.0
 * @changed ML 17.06.2010 - removed deprecations.
 */
public class Example2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* list with iterations. */
        List<Integer> il = new ArrayList<Integer>() {
            {
                add(100);
                add(1000);
                add(10000);
            }
        };

        /* list with object loadings. */
        List<Integer> ol = new ArrayList<Integer>() {
            {
                add(100);
                add(1000);
                add(10000);
            }
        };

        /* create the suite. */
        BenchmarkSuite bs = DefaultIterationObjectLoadBenchmarkSuite.create(il, ol);

        /* add some benches. */
        bs.addBenchmark(new TraverseForEachArrayListStringBenchmark());
        bs.addBenchmark(new TraverseHighSpeedIdiomArrayListStringBenchmark());

        /* execute the suite. */
        IterationObjectLoadBenchmarkSuiteResult bsr =
                (IterationObjectLoadBenchmarkSuiteResult) bs.execute();

        /* create a renderer. */
        /*
         * @doc jMibs/II/Getting Started Guide/1. Object load/4. How report my results with jFree?{
         * To create a JFreeChart for an object load suite result, use class
         * &quot;JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer&quot;. It produces
         * a simple chart from your results. The application is as the string renderer. It
         * renders to an JFreeChart object. Simply switch the renderer like following:}
         * @doc jMibs/II/Getting Started Guide/1. Object load/4. How report my results with jFree?(Pre){
         * BenchmarkSuiteResultRenderer<JFreeChart> bsrr = JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer.create(); }
         */
        BenchmarkSuiteResultRenderer<JFreeChart> bsrr =
                JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer.create();

        /* display the results. */
        /*
         * @doc jMibs/II/Getting Started Guide/1. Object load/4. How report my results with jFree?{
         * This chart you can pack into a chart panel and application frame, like this:}
         * @doc jMibs/II/Getting Started Guide/1. Object load/4. How report my results with jFree?(Pre){
         * ApplicationFrame af = new ApplicationFrame(bsr.getBenchmarkSuite().getName());
         * ChartPanel chartPanel = new ChartPanel(bsrr.render(bsr));
         * chartPanel.setFillZoomRectangle(true);
         * chartPanel.setMouseZoomable(true);
         * chartPanel.setPreferredSize(new Dimension(640, 480));
         * af.setContentPane(chartPanel);
         * af.pack(); RefineryUtilities.centerFrameOnScreen(af);
         * af.setVisible(true); }
         */
        ApplicationFrame af = new ApplicationFrame(bsr.getBenchmarkSuite().getName());
        ChartPanel chartPanel = new ChartPanel(bsrr.render(bsr));
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseZoomable(true);
        chartPanel.setPreferredSize(new Dimension(640, 480));
        af.setContentPane(chartPanel);
        af.pack();
        RefineryUtilities.centerFrameOnScreen(af);
        af.setVisible(true);
    }

}
