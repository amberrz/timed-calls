# Timed Calls

## Introduction

Timed Calls is an application that will allow you set a timer on the phone call that you choose. The application is able to set the timer on video calls as well.Now you are able to have late night calls or video calls and fall asleep on the line with the person. You won't have to worry if the phone alarm won't go off because your still on the line with the person. Timed calls will ended the call for you at the time you set it for. Know you won't be waking up late for school or work. Timed calls is set to end calls.


## Intended Users
* People who are in a long distance relationship.
    
   > As a person who is in a long distance relationship, I am always on the phone late at night and both my boyfriend and I will fall asleep on the call. when that would happen my phone alarm wouldn't go off. since I have downloaded the timed calls app I haven't woken up late for school .
* Parents who travel a lot for work and have little ones at home.
    
    >As a mother and a business woman I want to be able to video call my child until we both fall asleep together, not having to worry I wont wake up on time for the morning meeting.

## Design documentation
 
* [Wireframe diagram](wireframe.md)

* [ERD diagram](erd.md)

## Device and external services 

https://developer.android.com/guide/topics/providers/contacts-provider?hl=en
* This API will be used for the url to be able to choose to call multiple contacts with the timer.

https://developer.android.com/reference/android/app/AlarmManager
* The AlarmManager API is to set a timer for the url to connect it with the call.

https://developer.android.com/reference/android/provider/Telephony
 * The Telephony API is for the provider phone call to automatically disconnect.  