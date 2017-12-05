# CS3398-Cappucino-F2017
Fit or Die offers a new take on fitness apps. Unlike other fitness apps you can't just quit. In Fit or Die, users are given an avatar which corresponds to your activity in the app. As you become more fit, so will your avatar. However, if you stop actively working out, your avatar will die and your account will be locked. We know some people deserve second chances, so to get back into your account users can either complete a difficult fitness challenge or pay a small fee to open it back up.

<h3>Status 12/4/2017:</h3>

<b>Application:<b> The Login activity has sliding fragments that display info about the app while the bottom half of the screen allows users to log in. The sign-up page is linked to the login page and has fields for signing up.The login fields are connected to a database. The login button will take you to the homepage which has a functioning progress circle on the page, health bar, and a hot streak notification corresponding to your continued use in the app. A bottom navigation menu and side navigation drawer are implented in this version with active links to different pages. A functioning workout logger has been implemented with pre-set workouts avaialable. Using this logging feature will increase the avatars health. A vendor feature has been implemented but is not yet fully functional. 

<b>Design:</b> The design basics are mapped out in sketches and not yet implemented into the app. The artifacts that have been completed so far are visible in the comments under the issue that they apply to. 
  
  
<b>Database:</b> The database (MySQL) is set up and running. The API server is running and used to translate the JSON from the app to the database and back. It allows the app to store new user info and validate existing users. The API can easily be extended to translate other data to the database for the existing features we have and for and features we want to add in the next version.
  
  
<b>Miscellaneous:</b> Calendar functionality is not implemented at this time; however, the next sprint will involve implementing an interface for a user to interact with the Calendar.  This will allow the user to log his or her fitness progress.
