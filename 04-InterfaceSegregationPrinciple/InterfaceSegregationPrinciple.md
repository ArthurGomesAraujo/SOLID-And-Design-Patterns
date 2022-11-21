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
instead of forcing classes to implement unused methods. Let's take a quick example
with a `PersistenceService` interface, where it was designed to provide a contract
for the `UserPersistenceService`. But in order for this to happen, we have the
following four methods:

- save
- delete
- findById
- findByName

Those methods are all implemented under the UserPersistenceService implementation.
So now, let's say that we create another one, an `OrderPersistenceService`, and with
this new implementation, we implement the PersistenceService interface as well. Now
we have a problem. As far as we are concerned, the Orders cannot be found by name, 
but the interface implemented forces us to implement this method. This is a very 
common problem in projects where the interface is not well designed.

To fix this problem, we can remove the `findByName` method from the PersistenceService
interface and use it only on the `UserPersistenceService` implementation, where it
really belongs.