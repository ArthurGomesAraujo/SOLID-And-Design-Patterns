# Single Responsibility Principle

The formal definition for the first SOLID principle, 
Single Responsibility Principle, is that:

> ### _"There should never be more than one reason for a class to change"_  

What does this mean? It means that the class should 
provide a very focused functionality, or it addresses 
a specific concern of our desired functionality. Let's
take an example.

- We have a class called `AwesomeClass` that send a 
message to a remote server. What would the possible means
for changing this class?

<ol type="I">
<li>One possible reason is that the message protocol changed
from http to https. Then our class should be changed</li>
<li>Another reason is that we must change the message
type. For example, we sent JSON but we are not sending
it anymore.</li>
<li>It can also be changed to alter the connection
parameters, such as receiving different parameters
or adding authentication methods</li>
</ol>

Ok, but is this good? Of course not. There are multiple
reasons for changing this class, which means it is not
specific enough. So what can be done?

We can divide the class in a few classes:

- ServerCommunication - for handling the remote message to a server
- MessageCreator - for creating the JSON Message
- ConnectionHandler - for handling specific connection stuff.

Let's see another possible real example, that we will actually see on
the source code of this project:

We have a class called `UserController`. This class manages the user
creation and validation (which happens before saving the user), which
means that this class controls both persistence and validation for the
`User` entity.
So now we want to add more validations, or add more methods for 
specifically handle the entity. The single alteration of a need can
cause a modification on the whole class. That's because this class
is handling too many things, none specific. How do we solve that?

- We split in 2 more classes: `UserPersistenceService` and `UserValidator`
- On each class we will deal with specific things:
  - `UserPersistenceService` handles the saving of the entity on the 
  store. It will be in charge of dealing with our mocked Store and
  only this. If in a distant future we need to delete/update or even
  select entities, we will only be changing this specific class.
  - `UserValidator` will deal with validating the email, the phone
  and any kind of pattern that we will need to validate.