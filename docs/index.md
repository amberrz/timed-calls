# Timed Calls

## Introduction

Timed Calls is an application that will allow you set a timer on the phone call that you choose. The application is able to set the timer on video calls as well.Now you are able to have late night calls or video calls and fall asleep on the line with the person. You won't have to worry if the phone alarm won't go off because your still on the line with the person. Timed calls will ended the call for you at the time you set it for. Know you won't be waking up late for school or work. Timed calls is set to end calls.


## Intended Users
* People who are in a long distance relationship.
    
   > As a person who is in a long distance relationship, I am always on the phone late at night and both my boyfriend and I will fall asleep on the call. when that would happen my phone alarm wouldn't go off. since I have downloaded the timed calls app I haven't woken up late for school.
* Parents who travel a lot for work and have little ones at home.
    
    > As a business woman I tend to travel very often, the only time I have with my children is at night I want an application that will allow me to fall asleep on the line with them but also end the call for me minutes after falling asleep.  
* Students who have a bad schedule 

    > As a student I am always busy with school and at night is the only time I am able to make late phone calls I want an application that will  end my call if I fall asleep on the line with my best friend, and not wake up late for school.   
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