# MYPHARMA: A Pharmacy For All Your Needs

“Everything in life is uncertain. That is how you know you are existing in the world, the uncertainty. Of course, this is why we sometimes want to return to the past, because we know it, or think we do. It's a song we've heard.” We, being humans can get into an emergency condition, where there can be a requirement of instant medical attention. Since hospitals are not accessible to everyone in their proximity so sometimes getting proper medicine or proper first aid at the right time can prove to be life saviour. We are living in the 20th Century and have the comfort of ordering anything just while sitting at home. But the problem with all the current medicine delivery apps is that they have speculated delivery time and usually take more than 1 day to deliver the medicines. If there is an emergency condition, we are forced to wander in search of medical stores near our home and this is where our application comes into the picture.

We designed a system by using an object oriented paradigm where all the medical stores are present on the single platform. We have implemented this by forming several classes, each of them working is explained below. Basically we try to buit a real and user friendly application. The In this We have implemented an actionListner interface so that we can perform certain actions when clicking the buttons and design the action by overriding the actionPerformed method of actionListener interface. Inorder to design the panel and setting background images adjusted with margin we used swing library in java by importing javax.swing.* .We have used sql as well so that we can store the entered entries by including jar files which works as a jdbc driver.
•	Conn.java: This class is used to set up the connection with sql by setting a pathname for sql jdbc driver, so that we can enter entries in the table and can later verify separately to ensure details and can maintain details.

•	Welcome.java: This class will display the splash screen for a short interval of time.

•	Front.java: Constructor for this class will be called from the Welcome class . Front class will have three buttons: user login/signup , retailer login/signup  and details page , on clicking the given buttons the user will be directed to the requested page.

•	Details.java: Constructor for this class will be called from the Front class. It basically contains the list of nearby medical stores. It also contains the search button. 

•	Ulogin.java: Constructor of this class will be called when the user clicks on the login/signup button .This class accepts user name and password and in the end initialize constructor for user sign up page i.e Usignup class.

•	Usignup.java: This class accepts three entries from the user side one for  username , second for user password and third for confirm password. This page will redirect the user back to the login page after successfully signing in with a pop up “successfully registered” for user satisfaction.

•	UDashboard.java: Whenever the user login from Ulogin class this class is opens first. Here three buttons are present Profile, Exit, Home. By using  the Exit button a person exit the application.

•	UProfile.java: The constructor of this class is called from the UDashboard class. In this class a user can edit his/her personal details.

•	UHome.java: The constructor of this class is called from the UDashboard class. In this class a person can see the list of nearby medical stores. Here on this window a search button is also present.

•	USearch.java: The constructor of this class is called from the UHome class. Here in this class user has facility of searching the particular medicine and its availability on nearby medical stores with their personal details.

•	Ologin.java: Constructor for this class is initialized when the user clicks on the retailer button .Currently this class is similar to Userlogin class as it accepts retailer name and password but it will also have an option for retailers to add/edit medicine and all the details.It also contains constructor initializing for Rsignup class .

•	Osignup.java: This class is similar to Usignup which accepts retailer name , password and confirm password .After successfully signing retailer will be directed to Rlogin page.

•	Dashboard.java: Whenever the user login from Ologin class this class is opens first. Here three buttons are present Profile, Exit, Home. By using  the Exit button a person exit the application.

•	Profile.java: The constructor of this class is called from the ODashboard class. In this class a user can edit his/her personal details. Also in this class a owner is able to enter the medicines which he/she have.

•	OHome.java: The constructor of this class is called from the ODashboard class. In this class a person can see the list of nearby medical stores. Here on this window a search button is also present.

•	OSearch.java: The constructor of this class is called from the OHome class. Here in this class owner has facility of searching the particular medicine and its availability on nearby medical stores with their personal details. As if the medicine is not present on his/her store he/she can make it available to the needy one.
