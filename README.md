# talkingclock

Readme for talking clock application.

Talking clock application important classes

TalkingClockService
The  class which contain logic to convert numeric time into words.

TalkingClockController
This controller class is containing mapping for rest api where user can add query string to get time in words.
Following is the example of url pattern this service used.
/app/talkingclock/hh:mm(for example /app/talkingclock/20:20 will return Twenty past eight).

TalkingClockApplication
Main class to run reset API

TalkingClockApplicationMain
To run application where it print current time in words and if user passed any parameter in hh:mm format
then it will also get converted into word format

Unit test is also added to test service class which mainly perform business logic for this problem.

There are also two model classes, Response and ErrorMessage which would contain payload of response and
return time in descriptive message and in case of any exception ErrorMessage will be return.


