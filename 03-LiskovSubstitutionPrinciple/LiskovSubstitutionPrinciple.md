# Liskov Substitution Principle

The formal definition for the third SOLID principle,
Liskov Substitution Principle, is that:

> ### _"We should be able to substitute base class objects with child class objects and this should not alter the behavior/characteristics of the program."_

Even though this is very simple, lets keep in mind that we are not talking only about
simple type-based substitution following the language rules, but also behavioral 
subtyping.

This principle means that if we substitute object 1 for object 2 (which is a child of
object 1), the behavior of the code should not be altered. 

To fully understand, let's take a look at our sample code. Now we have a `Square` and
a `Rectangle`. We know that squares are a special type of rectangles, so the obvious
choice is to make square extends rectangle. But will this impact on the functioning 
of our software?
If we use the Square class as a special type of Rectangle, by inheritance, we may find
some problems when trying to compute the area or create assertions. If we try to assert
the square the same way we do with the rectangle, as one derives from another, we
will find a wrong assertion, as rectangles have different width and height, but 
squares have the same width and height. This can cause even more issues if we 
are dealing with more calculations regarding the calculations of a rectangle 
versus the calculations of a square, making this relationship invalid, as it violates
a lot of use cases.
To solve this, let's make clear that square and rectangle are not just variations of
one another, but instead an implementation of a `Shape` interface. Now we can write
a specific test case and erase the impression of using a special type of rectangle.
