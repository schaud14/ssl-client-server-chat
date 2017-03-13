# ssl-client-server-chat

You will implement a client and a server using Secure Socket Layer (SSL). Upon connection,
the client prompts the user to enter a string and sends the string to the server. The server prints
the string received and the number of characters in the string.

The server is invoked as
sslserv <server_port> (C/C++)
java SslServ <server_port > (Java)

<server_port> specifies the port number on which the server listens for the connection.
The client is invoked as
sslcli <server_domain> <server_port> (C/C++)
java SslCli <server_domain> <server_port> (Java)

<server_domain> specifies the domain name of the server, i.e., bingsuns.binghamton.edu
You can use any code available on the web for SSL socket programming. However, you
must write your own code for sending/receiving the string and computing the number of
characters in the string. You should also generate the certificate by yourself. Please use
one of your group members' name when generating the certificate (other information can
be forged).
