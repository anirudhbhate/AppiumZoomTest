## Description

This project contains a BaseClass and a ZoomTest Class. The test does the following:

* Launch Zoom app from an apk sourced locally, update the apk path in the BaseClass Desired capabilities
* Find the `Join Meeting` button and click it
* Find the `Join` button and verify it is disabled
* Add an invalid meeting code and verify the button is enabled once 9 digits are entered
* Click on the `Join` button 
* Verify an invalid meeting popup appears and the text in it is accurate 


### Instructions to run 

* Install appium using `npm install -g appium`
* Create a virtual device using Android studio
* Update the desired capabilities in the base class depending on your emulator 
* Ensure your appium config has JAVA and ANDROID env variables set up correctly
* Start up the appium server, and update the URL in BaseClass based on your configuration
* Start up the emulator 
* Run the ZoomTest class using TestNG 


# Test run recording

![ZoomTest](https://user-images.githubusercontent.com/128199524/227424792-f9efe8ba-b39b-431f-b2de-e07e587aecf1.gif)


