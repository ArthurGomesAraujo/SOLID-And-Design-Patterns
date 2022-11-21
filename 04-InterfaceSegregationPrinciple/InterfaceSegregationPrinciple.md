# Interface Segregation Principle

The formal definition for the fourth SOLID principle,
Interface Segregation Principle, is that:

> ### _"Clients should not be forced to depend upon interfaces that they do not use."_

We can also say that _"Clients should not depend on __methods__ that they do not use."_.
This is specifically talking about interface pollution, which means that we should not
have big, large interfaces and unrelated methods. To identify that we currently have
those polluted interfaces, we can see:

- Classes have empty method implementations
- Method implementations throw UnsupportedOperationException or similar errors.
- Method implementations return null or default/dummy values.

It is better to break big interfaces so that the contracts are cohesive and related,
instead of forcing classes to implement unused methods. 