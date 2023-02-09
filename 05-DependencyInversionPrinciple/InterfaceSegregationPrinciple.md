# Dependency Inversion Principle

The formal definition for the fifth SOLID principle,
Dependency Inversion Principle, is that:

> ### _"A. High level modules should not depend upon low level modules. Both should depend upon abstractions_
> ### _B. Abstractions should not depend on details. Details should depend upon abstractions."_

Now this is the last one, and also the big one as well. If you are
using a framework such as Spring, it already implements this principle.
To better understand it, let's first understand what dependency currently
is.

Let's say that we want to print a string on the console through java. We
actually have something like this:

```java
public void printMe() {
    System.out.println("Hello!");
}
```

This code is telling us that we have a dependency on the "out" object.
Another example would be:

```java
public void writeReport() {
    Report report = new Report();
    
    JSONFormatter formatter = new JSONFormatter();
    String report = formatter.format(report);
    FileWriter writer = new FileWriter("report.json");
}
```

On the code above, we have 3 dependencies: the `Report`, the `JSONFormatter`
and the `FileWriter`. Even though Report is under our domain, it is
still a dependency. So basically, dependency means everything our code
needs for it to work.

What happens when somebody comes and says that it does not want JSON 
anymore, but HTML instead? We will need to modify the existing code.
Same goes if we have to post it on a server somewhere. And everytime
you change a code that already exists and is tested, there's a possibility
of introducing bugs. A higher level module should not depend on lower
level modules, but on an abstraction instead. And what does an abstraction
means in this case? It means, for example, an interface. Instead of
using those same classes, we can create 2 interfaces: a `Writer` and a
`Formatter` and use it on the classes, like:

```java
public void writeReport(Formatter formatter, Writer writer) {
    Report report = new Report();
    
    String report = formatter.format(report);
    
    writer.write("myreport");
}
```