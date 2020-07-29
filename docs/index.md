# Timed Calls

## Introduction

Timed Calls is an application that will allow you set a timer on the phone call that you choose. The application is able to set the timer on video calls as well. Now you are able to have late night calls or video calls and fall asleep on the line with the person. You won't have to worry if the phone alarm won't go off because your still on the line with the person. Timed calls will ended the call for you at the time you set it for. Know you won't be waking up late for school or work. Timed calls is set to end calls.The reason I choose to work on this application is because I had a friend who was in a long-distance relationship and she always was waking up late for class because her alarm did not go off. For the reason of her still being on the call from last night. As an android user I have had that issue ass well and having an app that is able to end your phone call automatically from a timer is great to depend on a late night call knowing your going to fall asleep on the line .The key functional elements of the application are the application right now is able to run. The application can get the users permission to use the contact in the application. The user is able to press on the contact of their choice and, a pop out appears for the user to set the time for the call they have chosen. The user is also able to go to the history list and choose from there on a previous call and time the user had set-up for.   

* Set the timer to any contact on your phone
* History list
* automatically ends calls

## Intended Users
* People who are in a long distance relationship.
    
   > As a person who is in a long distance relationship, I am always on the phone late at night and both my boyfriend and I will fall asleep on the call. when that would happen my phone alarm wouldn't go off. since I have downloaded the timed calls app I haven't woken up late for school.
* Parents who travel a lot for work and have little ones at home.
    
    > As a business woman I tend to travel very often, the only time I have with my children is at night I want an application that will allow me to fall asleep on the line with them but also end the call for me minutes after falling asleep.  
* Students who have a bad schedule 

    > As a student I am always busy with school and at night is the only time I am able to make late phone calls I want an application that will  end my call if I fall asleep on the line with my best friend, and not wake up late for school.   

## Current State of App 

The current state that the application is at it is at a building and running state. The app appears on the emulator and the only page that work at the moment is the contact list it has a floating button and when you click on one of the contacts a pop up appears to set the time and a list view button to choose different  contacts on the contact list. the bottom buttons on the application navigate to the correct pages but timer and history are empty at the moment. The application has a few lines of red and code that does not compile but I have them commented out for the application to compile. Some of the Fragment classes that have little to incomplete code . There are also TODOs  let to work on.

#### Improvements 
* Have a complete history list
* Working buttons 

#### Stretch Goals 
* Able to connect this app with other apps that have calling apps 


## Design documentation
 
* [Wireframe diagram](wireframe.md)

* [ERD diagram](erd.md)

## Entities

* [Timer Entity](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/model/entity/Timer.java)

* [History Entity](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/model/entity/History.java)

## Daos

* [Timer Dao](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/model/dao/TimerDao.java)

* [History Dao](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/model/dao/HistoryDao.java)

## Repositories 

* [Timer Repository](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/service/TimerRepository.java)

* [History Repository](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/service/HistoryRepository.java)

## Database

* [Timed Calls Database](https://github.com/amberrz/timed-calls/blob/master/app/src/main/java/edu/cnm/deepdive/timedcalls/service/TimedCallsDatabase.java)

## DDL

* [Data Definition Language](ddl.md) 

## Copyrights & licenses
* [copyright statements and license information](notice.md)

## Build instructions
* [Import the project](build.md)

## The user instructions

[instructions to Timed Calls]()

## Device & external services 

#### Developer.Android 

https://developer.android.com/guide/topics/providers/contacts-provider?hl=en

* The Contact-Provider API will allow the Provider to set the timer on multiple contacts on their contact list when they make a call. 

https://developer.android.com/reference/android/app/AlarmManager

* The AlarmManager API will allow the Provider set the time on the call on their contact list.

https://developer.android.com/reference/android/provider/Telephony

 * The Telephony API is for the application to automatically disconnect the call that the provider has set it for.  