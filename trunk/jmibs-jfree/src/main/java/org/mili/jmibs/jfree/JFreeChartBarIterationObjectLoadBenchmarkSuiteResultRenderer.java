/**
 * JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer.java
 *
 * 12.04.2010
 *
 * Copyright 2010 Michael Lieshoff
 */

/*
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

package org.mili.jmibs.jfree;

import java.awt.*;
import java.util.List;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;
import org.mili.jmibs.api.*;

/**
 * This class defines a special implementation of interface BenchmarkSuiteResultRenderer that
 * renders the benchmark suite results in a jFreeChart representation.
 *
 * @author Michael Lieshoff
 * @version 1.0 12.04.2010
 * @since 1.0
 */
public class JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer implements
        BenchmarkSuiteResultRenderer<JFreeChart> {

    /**
     * creates a new string iteration object load benchmark suite result renderer.
     */
    protected JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer() {
        super();
    }

    /**
     * creates a new string iteration object load benchmark suite result renderer.
     *
     * @return new string iteration object load benchmark suite result renderer.
     */
    public static JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer create() {
        return new JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer();
    }

    @Override
    public JFreeChart render(BenchmarkSuiteResult bsr) {
        CategoryDataset dataset = this.createDataset(bsr.getExecuteResults());
        JFreeChart chart = this.createChart(bsr.getBenchmarkSuite().getName(), dataset);
        return chart;
    }

    private CategoryDataset createDataset(List<BenchmarkResult> lbr) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        for (int i = 0, n = lbr.size(); i < n; i++) {
            BenchmarkResult br = lbr.get(i);
            IterationObjectLoadBenchmarkContext iolbc = (IterationObjectLoadBenchmarkContext) br
                    .getBenchmarkContext();
            Benchmark b = iolbc.getBenchmark();
            int ic = iolbc.getIteration();
            int oc = iolbc.getObjectLoad();
            ds.addValue(br.getTotalTimeNanos(), String.valueOf(ic) + "/" + String.valueOf(oc),
                    b.getName());
        }
        return ds;
    }

    private JFreeChart createChart(String title, CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(title,
                "Benchmark (Iteration/Object Loading)", "Time in ns", dataset,
                PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0,
                0, 64));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0,
                64, 0));
        GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64,
                0, 0));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(Math.PI / 6.0));
        return chart;

    }

}
