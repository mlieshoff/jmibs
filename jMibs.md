## jMibs 1.0 ##

Michael Lieshoff

29.04.10


## I ##


#### Introduction ####

jMibs is a Java micro-benchmarking suite.

## II ##


#### Getting Started Guide ####

This guide is intended to show about the first use of jMibs and introduce in the base application.
First get the right suite. Use a benchmark suite, based on iteration and some object loading. This means we run benchmarks in suite n-times with m-objects. The suite type for this is defined in interface "IterationObjectLoadBenchmarkSuite". The default class for this interface defines all needed.
Define a list with iteration counts. Let's try with 10, 100 and 1.000 bench iteration. This means a single benchmark will be executed in times 10, 100 and 1.000.
```

 List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);
```

Define a list with object loading counts. Let's try with 100 and 1.000 object loading counts. This means a single benchmark will be used intern 100 and 1.000 object for each defined iteration count.
```

 List<Integer> ol = new ArrayList<Integer>(){{add(100); add(1000);
```

Then get an instance for the right suite and both lists.
```

 BenchmarkSuite bs = DefaultIterationObjectLoadBenchmarkSuite.create("Example1", il, ol); 
```


#### 1. What is jMibs? ####

jMibs is a benchmarking suite to execute micro several benchmarks. It tries to answer the questions about performance. How many micro-seconds my algorithm need to be completed? When i try it 10.000 times, will it constant perform oder non-perform? If i uses thousands of objects in, how many seconds it need to be compledted? jMibs tries to work this job. You can define own benches and access own classes to check out the performance. You can extend jMibs with basic principles of Java software development. The try is to make extension easy.

#### 2. How do i setup? ####

Setup is easy as possible. Get the jMibs archive file and use the archive on your classpath.

#### 3. How do i bind a bench in a suite? ####

Two example benchmarks are prepared. The benchmark class "TraverseForEachArrayListStringBenchmark" defines a benchmark to traverse an ArrayList of String objects with for-each idiom. This benchmark will be added to the suite above with the addBenchmark() method.
```

 bs.addBenchmarkClass(TraverseForEachArrayListStringBenchmark.class); 
```

Second prepared benchmark class is "TraverseHighSpeedIdiomArrayListStringBenchmark". It defines a benchmark to traverse an ArrayList of String objects with high-speed-for idiom. This benchmark will be added to the suite above with the addBenchmark() method.
```

 bs.addBenchmarkClass(TraverseHighSpeedIdiomArrayListStringBenchmark.class); 
```

Then the suite can be started with execute() method. The return value contains the benchmark results for all benchmarks, in all iteration with all object loading counts, in suite.
```

 IterationObjectLoadBenchmarkSuiteResult bsr = (IterationObjectLoadBenchmarkSuiteResult) bs.execute(); 
```


#### 3. How do i make my own bench? ####

Your own benchmark can be maked with the two example benchmarks as pattern. For iteration/object loading based benchmarks extends the abstract class "AbstractObjectLoadBenchmark". For some specially custom benchmarks based on other facts extends the abstract class "AbstractBenchmark" or implement the interface "Benchmark". You will see some output of string rendered suite results.

#### 4. How do i report my results? ####

Next a more human readable interpretation of suite result seems to be good. This job is done be renderers implementing the interface "BenchmarkSuiteResultRenderer". We use a simple implementation to render the result information in a simple string table. The class used is "StringIterationObjectLoadBenchmarkSuiteResultRenderer".
```

 BenchmarkSuiteResultRenderer<String> bsrr = StringIterationObjectLoadBenchmarkSuiteResultRenderer.create();
 System.out.println(bsrr.render(bsr)); 
```


#### 5. How report my results with jFree? ####

For jFreeChart there momently one result renderer called "JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer". It produces a simple chart from your results. The application is as the string renderer. It renders to an JFreeChart object. Simply switch the renderer like following:
```

 BenchmarkSuiteResultRenderer<JFreeChart> bsrr = JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer.create(); 
```

This chart you can pack into a chart panel and application frame, like this:
```

 ApplicationFrame af = new ApplicationFrame(bsr.getBenchmarkSuite().getName());
 ChartPanel chartPanel = new ChartPanel(bsrr.render(bsr));
 chartPanel.setFillZoomRectangle(true);
 chartPanel.setMouseZoomable(true);
 chartPanel.setPreferredSize(new Dimension(640, 480));
 af.setContentPane(chartPanel);
 af.pack(); RefineryUtilities.centerFrameOnScreen(af);
 af.setVisible(true); 
```


#### 6. Running the examples ####

Examples can be found in the project "jmibs-examples" or, with jFree, in "jmibs-jfree". The classes with prefix "Example" in the packages "examples" are able to start with Maven like this:
```

 jmibs/jmibs-examples/mvn exec:java -Dexec.mainClass="org.mili.jmibs.examples.Example1"
```

or
```

 jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example2"
 jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example3"
 jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example4"
 jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example5"
 jmibs/jmibs-jfree/mvn exec:java -Dexec.mainClass="org.mili.jmibs.jfree.examples.Example6"
```


## III ##


#### How it works? ####



#### 1. Benchmark suites ####



#### Iteration object load suite ####

The execute method starts the proceeded to execute all benchmarks assigned to this suite. First a virtual machine warm up phase is proceeding that tries to activate the hot spot. By default this phase will prepare and execute a benchmark with a one object loading 1.000.000 times. This integer value can be set with property "org.mili.jmibs.impl.WarmUpHotSpotCount". After this phase all benchmarks will be prepared and executed in order with defined suite settings. Then the suite will prepare and execute all the benchmarks again in reverse order and merge the results. This ends the execution of the suite.



