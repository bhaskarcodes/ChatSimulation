# ChatSimulation  

This is a simple server client chat program. Multithreading has been implemented in server that enables multiple clients 
to connect with the server. The session terminates when client sends BYE to the server. 

Classes :  

<b>ServerDriver :</b> The main program that assigns one thread per client accepted
<b>MyServer     :</b> Server code  
<b>MyClient     :</b> Client code

To run the program :  

<b>
javac ServerDriver.java  
java ServerDriver <port-number>


javac MyClient.java  
java MyClient <server's IP Address> <port-number>
</b>
