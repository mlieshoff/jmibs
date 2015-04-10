## jMibs 1.1 ##

Michael Lieshoff

18.06.10

## I ##

#### 1. Introduction ####
jMibs is a Java micro-benchmarking suite.

#### 1.1. 1. What is jMibs? ####
jMibs is a benchmarking suite to execute micro several benchmarks. It tries to answer the questions about performance. How many micro-seconds my algorithm need to be completed? When i try it 10.000 times, will it constant perform oder non-perform? If i uses thousands of objects in, how many seconds it need to be compledted? jMibs tries to work this job. You can define own benches and access own classes to check out the performance. You can extend jMibs with basic principles of Java software development. The try is to make extension easy.

#### 1.2. 2. How do i setup? ####
Setup is easy as possible. Get the jMibs archive file and use the archive on your classpath.

## II ##

#### 2. Getting Started Guide ####
This guide is intended to show about the first use of jMibs and introduce in the base application.

#### 2.1. 1. Object load ####
First start with object loading benchmark suite. This suite is based on iterations and some object loadings. This means we run benchmarks in suite n-times with m-objects. The suite type for this is defined in interface "IterationObjectLoadBenchmarkSuite". The default class for this interface defines all needed.Define a list with iteration counts. Let's try with 10, 100 and 1.000 bench iterations. This means a single benchmark will be executed in times 10, 100 and 1.000.
```

 List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);
```
Define a list with object loading counts. Let's try with 100 and 1.000 object loading counts. This means a single benchmark will be used intern 100 and 1.000 object for each defined iteration count.
```

 List<Integer> ol = new ArrayList<Integer>(){{add(100); add(1000);
```
Then get an instance for the iteration object load suite and both lists.
```

 BenchmarkSuite bs = DefaultIterationObjectLoadBenchmarkSuite.create("Example1", il, ol); 
```


#### 2.1.1. 1. How do i bind a bench in a suite? ####
Two example benchmarks are prepared. The benchmark class "TraverseForEachArrayListStringBenchmark" defines a benchmark to traverse an ArrayList of String objects with for-each. This benchmark will be added to the suite above with the addBenchmark() method. Notice that the method addBenchmarkClass() is now deprecated. We add now instances of benches, not classes.
```

 bs.addBenchmark(new TraverseForEachArrayListStringBenchmark()); 
```
Second prepared benchmark class is "TraverseHighSpeedIdiomArrayListStringBenchmark". It defines a benchmark to traverse an ArrayList of String objects with high-speed-for idiom. This benchmark will be added to the suite above with the addBenchmark() method.
```

 bs.addBenchmark(new TraverseHighSpeedIdiomArrayListStringBenchmark()); 
```
Then the suite can be started with execute() method. The return value contains the benchmark results for all benchmarks, in all iteration with all object loading counts, in suite.
```

 IterationObjectLoadBenchmarkSuiteResult bsr = (IterationObjectLoadBenchmarkSuiteResult) bs.execute(); 
```


#### 2.1.2. 2. How do i report my results? ####
Next a more human readable interpretation of suite result seems to be good. This job is done by renderers implementing the interface "BenchmarkSuiteResultRenderer". We use a simple implementation to render the result information in a simple string table. The class used is "StringIterationObjectLoadBenchmarkSuiteResultRenderer".
```

 BenchmarkSuiteResultRenderer<String> bsrr = StringIterationObjectLoadBenchmarkSuiteResultRenderer.create();
 System.out.println(bsrr.render(bsr)); 
```


#### 2.1.3. 3. How do i make my own bench? ####
Your own benchmark can be maked with the two example benchmarks as pattern. For iteration/object loading based benchmarks extends the abstract class "AbstractObjectLoadBenchmark". For some specially custom benchmarks based on other facts extends the abstract class "AbstractBenchmark" or implement the interface "Benchmark".

#### 2.1.4. 4. How report my results with jFree? ####
To create a JFreeChart for an object load suite result, use class "JFreeChartBarIterationObjectLoadBenchmarkSuiteResultRenderer". It produces a simple chart from your results. The application is as the string renderer. It renders to an JFreeChart object. Simply switch the renderer like following:
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


#### 2.2. 2. Interval ####
How would a function like Fibonacci be benched? For this behavior there is the interval benchmark suite. It's perfectly designed for things like: Do the function 10, 100, 1000 times with values from 1..10, 50..75 and 1..1000. The suite type is defined in interface "IterationIntervalBenchmarkSuite". The default class for this interface defines all needed.Define a list with iteration counts. Let's try with 10, 100 and 1.000 bench iterations. This means a single benchmark will be executed in times 10, 100 and 1.000.
```

 List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);
```
Define a list with intervals. Remember interval has minimum and maximum. Let's try an interval from 1 to 10 and 50 to 100. This means a single benchmark will be executed for the both intervals. The intervals used are integer intervals, mean min and max are integer values. There long interval too, and for other function custom intervals can be created.
```

 List<IntegerInterval> ol = new ArrayList<IntegerInterval>(){{IntegerInterval.create(0, 10), IntegerInterval.create(50, 100)
```
Then get an instance for the right suite and both lists.
```

 BenchmarkSuite bs = DefaultIterationIntervalBenchmarkSuite.create("Example3", il, ol); 
```


#### 2.2.1. 1. How do i bind a bench in a suite? ####
Two example benchmarks are prepared. The benchmark class "FibonacciEndRecursiveBenchmark" defines a benchmark to computeFibonacci number end recursive. This benchmark will be added to the suite above with the addBenchmark() method.
```

 bs.addBenchmark(new FibonacciEndRecursiveBenchmark()); 
```
Second prepared benchmark class is "FibonacciRecursiveBenchmark". It defines a benchmark to compute Fibonacci number recursive. This benchmark will be added to the suite above with the addBenchmark() method.
```

 bs.addBenchmark(new FibonacciRecursiveBenchmark()); 
```
Then the suite can be started with execute() method. The return value contains the benchmark results for all benchmarks, in all iteration with all intervals, in suite.
```

 IterationIntervalBenchmarkSuiteResult<IntegerInterval> bsr = (IterationIntervalBenchmarkSuiteResult) bs.execute(); 
```


#### 2.2.2. 2. How do i report my results? ####
Next a more human readable interpretation of suite result seems to be good. This job is done by renderers implementing the interface "BenchmarkSuiteResultRenderer". We use a simple implementation to render the result information in a simple string table. The class used is "StringIterationIntervalBenchmarkSuiteResultRenderer".
```

 BenchmarkSuiteResultRenderer<String> bsrr = StringIterationIntervalBenchmarkSuiteResultRenderer.create();
 System.out.println(bsrr.render(bsr)); 
```


#### 2.2.3. 3. How do i make my own bench? ####
Your own benchmark can be maked with the two example benchmarks as pattern. For iteration/interval based benchmarks extends the abstract class "AbstractIntervalBenchmark". For some specially custom benchmarks based on other facts extends the abstract class "AbstractBenchmark" or implement the interface "Benchmark".

#### 2.3. 3. Interval and object load ####
There is a combined benchmark suite that combines object load with interval. This means we run benchmarks in suite n-times with m-objects in i-intervals. The suite type for this is defined in interface "IterationObjectLoadIntervalBenchmarkSuite". The default class for this interface defines all needed.Define a list with iteration counts. Let's try with 10, 100 and 1.000 bench iterations. This means a single benchmark will be executed in times 10, 100 and 1.000.
```

 List<Integer> il = new ArrayList<Integer>(){{add(10); add(100); add(1000);
```
Define a list with object loading counts. Let's try with 100 and 1.000 object loading counts. This means a single benchmark will be used intern 100 and 1.000 object for each defined iteration count.
```

 List<Integer> ol = new ArrayList<Integer>(){{add(100); add(1000);
```
Define a list with intervals. Remember interval has minimum and maximum. Let's try an interval from 1 to 10 and 50 to 100. This means a single benchmark will be executed for the both intervals. The intervals used are integer intervals, mean min and max are integer values. There long interval too, and for other function custom intervals can be created.
```

 List<IntegerInterval> ol = new ArrayList<IntegerInterval>(){{IntegerInterval.create(0, 10), IntegerInterval.create(50, 100)
```
Then get an instance for the iteration object load interval suite and the three lists.
```

 BenchmarkSuite bs = DefaultIterationObjectLoadIntervalBenchmarkSuite.create("Example4", il, ol, itl); 
```


#### 2.3.1. 1. How do i bind a bench in a suite? ####
One example benchmark is prepared. The benchmark class "ObjectLoadIntervalBenchmark" defines a benchmark to do the job. This benchmark will be added to the suite above with the addBenchmark() method.
```

 bs.addBenchmark(new ObjectLoadIntervalBenchmark()); 
```
Then the suite can be started with execute() method. The return value contains the benchmark results for all benchmarks, in all iteration with all object loading counts and all intervals, in suite.
```

 IterationObjectLoadIntervalBenchmarkSuiteResult<IntegerInterval> bsr = (IterationObjectLoadIntervalBenchmarkSuiteResult<IntegerInterval>) bs.execute(); 
```


#### 2.3.2. 2. How do i report my results? ####
Next a more human readable interpretation of suite result seems to be good. This job is done by renderers implementing the interface "BenchmarkSuiteResultRenderer". We use a simple implementation to render the result information in a simple string table. The class used is "StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer".
```

 BenchmarkSuiteResultRenderer<String> bsrr = StringIterationObjectLoadIntervalBenchmarkSuiteResultRenderer.create();
 System.out.println(bsrr.render(bsr)); 
```


#### 2.3.3. 3. How do i make my own bench? ####
Your own benchmark can be maked with the example benchmark as pattern. For iteration/object loading/interval based benchmarks extends the abstract class "AbstractObjectLoadIntervalBenchmark". For some specially custom benchmarks based on other facts extends the abstract class "AbstractBenchmark" or implement the interface "Benchmark".

#### 2.4. 4. AdHoc benches ####
Like to ad hoc bench something or don't like to write a bench class? Then ad hoc benches should be used. Ad hoc benches are a short version of benchmarks. They only must created with two anonymous implemented function for prepare and execute. Then they are ready. Combined with createAndRun() method in each suite they can started quickly. Nothing to inherit or overload, simply create a class with create() method.

#### 2.4.1. 1. Object load ####
For object load benches use create() method from "AdHocObjectLoadBenchmark". Notice that you must declare the model outside of the benchmark, because prepare and execute methods would access the model.Next use createAndRun() method from calls "DefaultIterationObjectLoadBenchmarkSuite". Parameters are the name of the suite, a renderer class, an array with benchmarks, iterations and object loads. The suite will be created and started automatically.

#### 2.4.2. 2. Interval ####
For interval benches use create() method from "AdHocIntervalBenchmark".Next use createAndRun() method from calls "DefaultIterationIntervalBenchmarkSuite". Parameters are the name of the suite, a renderer class, an array with benchmarks, iterations and intervals. The suite will be created and started automatically.

#### 2.4.3. 3. Interval and object load ####
For object load and interval benches use create() method from "AdHocObjectLoadIntervalBenchmark".Next use createAndRun() method from calls "DefaultIterationObjectLoadIntervalBenchmarkSuite". Parameters are the name of the suite, a renderer class, an array with benchmarks, iterations, object loads and intervals. The suite will be created and started automatically.

#### 2.5. 5. Running the examples ####
Examples can be found in the project "jmibs-examples" or, with jFree, in "jmibs-jfree". The classes with prefix "Example" in the packages "examples" are able to start with Maven like this:
```

 jmibs/jmibs-examples/mvn exec:java -Dexec.mainClass="org.mili.jmibs.examples.Example1"
 jmibs/jmibs-examples/mvn exec:java -Dexec.mainClass="org.mili.jmibs.examples.Example2"
 jmibs/jmibs-examples/mvn exec:java -Dexec.mainClass="org.mili.jmibs.examples.Example3"
 jmibs/jmibs-examples/mvn exec:java -Dexec.mainClass="org.mili.jmibs.examples.Example4"
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

#### 3. How it works? ####


#### 3.1. 1. Benchmark suites ####


#### 3.1.1. Iteration interval suite ####
The execute method starts the proceeded to execute all benchmarks assigned to this suite. First a virtual machine warm up phase is proceeding that tries to activate the hot spot. By default this phase will prepare and execute a benchmark with a minimum interval 1.000.000 times. This integer value can be set with property "org.mili.jmibs.impl.DefaultIterationIntervalBenchmarkSuiteWarmUpHotSpotCount". After this phase all benchmarks will be prepared and executed in order with defined suite settings. Then the suite will prepare and execute all the benchmarks again in reverse order and merge the results. This ends the execution of the suite.

#### 3.1.2. Iteration object load interval suite ####
The execute method starts the proceeded to execute all benchmarks assigned to this suite. First a virtual machine warm up phase is proceeding that tries to activate the hot spot. By default this phase will prepare and execute a benchmark with a one object loading 1.000.000 times. This integer value can be set with property "org.mili.jmibs.impl.DefaultIterationObjectLoadIntervalBenchmarkSuite.WarmUpHotSpotCount". After this phase all benchmarks will be prepared and executed in order with defined suite settings. Then the suite will prepare and execute all the benchmarks again in reverse order and merge the results. This ends the execution of the suite.

#### 3.1.3. Iteration object load suite ####
The execute method starts the proceeded to execute all benchmarks assigned to this suite. First a virtual machine warm up phase is proceeding that tries to activate the hot spot. By default this phase will prepare and execute a benchmark with a one object loading 1.000.000 times. This integer value can be set with property "org.mili.jmibs.impl.DefaultIterationObjectLoadBenchmarkSuite.WarmUpHotSpotCount". After this phase all benchmarks will be prepared and executed in order with defined suite settings. Then the suite will prepare and execute all the benchmarks again in reverse order and merge the results. This ends the execution of the suite.


