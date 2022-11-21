# Open-Closed Principle

The formal definition for the second SOLID principle,
Open-Closed Principle, is that:

> ### _"Software entities should be open for extension but closed for modification"_

Seems pretty difficult but actually is one of the easiest principles.
Let's split the phrase in two and analyze its meaning:

1. Open for Extension - Should be able to extend the existing behaviour
2. Closed for Modification - Existing code remains unchanged

In this example, let's take the scenario of an Internet Provider. For this,
we will have 2 classes called `ISPSubscriber` and `PhoneSubscriber`.
Both of them receive some parameters like `subscriberId, address, phoneNumber
and baseRate`. Those parameters happen on both classes and are used to
calculate the bill of the client. For this to work, we created the
classes by duplicating the parameters, which is not a very good practice
as you generate repetition on the code. Also, if you want to add a VoIP
service, you'll need to duplicate it again, and if more properties are
added for all the services provided, such as a date from where the
person contracted the service, so the provider can grant some discount,
or even methods that are common for all the services (let's take the
discount example again), we will have to alter 3 classes for it to work.
Pretty bad to deal with even the slightest of the changes, right?

To change this reality, we can use the Open-Closed Principle, and create
a new generic class that contains all the extensible methods and variables,
and call it `Subscriber`. From now, we can extend the Subscriber on
`ISPSubscriber` and `PhoneSubscriber`, inheriting its variables and overriding
its `calculateBill` method. Note that the `Subscriber` class is closed now
for modification, as we finished adding everything that a Subscriber needs.
Now, it is open for extension, meaning that the method can be extended
and override depending on the use case.