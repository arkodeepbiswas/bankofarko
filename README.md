# The Swiizz Bank
<div align="center">
<a>
<img src="mywebsite/swiizz.jpg" alt="Logo" width="80" height="80">
</a>
<h3 align="center">THE SWIIZZ BANK</h3>
  </div>
  
  <details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a> About The Project </a>
      <ul>
        <li>What can admin do?</li>
        <li>What can customers do?</li>
        <li>How this project is made?</li>
      </ul>
    </li>
    <li>
       Built With
    </li>
    <li>Installation & Getting Started</li>
    <li>Contact</li>
  </ol>
</details>


## About The Project

Hi, this project is an bank application for a virtual bank where we can manage most of the
bank related tasks, in which we have two different portals for admin and customer, where they can handle 
all of there bank related functionality and queries.


### What can admin do ?

* First of all, no customers can register themselves on their own. So only admin can register a customer in the bank.
* Admin can check the total number of customers and their statuses whether the one is Active or Inactive.
* Can activate or deactivate a customer. 

### What customers can do?

* Once admin registers one, customers can see their profile details on their dashboard.
* Can check the transaction history of their account.
* Customers can send money to anyone using account number and ifsc code.


#### How the project is made?

It is basically an 3 tier arhitecture project where i have used tomcat to host all the html pages on server
and the API's are implemented on IntelliJ in java and have connected it to SQL databse (workbench) for saving 
all the information of the entities.

### Built With

* [Java]
* [SQl]
* [HTML]
* [Jquery]


##  Installation & Getting Started

To run with this project, one firstly needs to install external dependencies or pre requities :-

* IntelliJ Idea and some plugins like scala, ebean and have to configure them in intellij.
* Java 1.8 or higher.
* Sbt version 1.5.2 and sbt executer.
* Play framework for API development.
* MySQL workbench.
* Tomcat Server Host.

After installing all the tools and plugins, one has to open the main project in Intellij Idea
and if all the dependencies are good to go, Open all the html pages in a seperate document and host
them on tomcat server, before doing that please ensure you have setted up the databse.
And after doing all the neccessary steps run sbt and html pages.

You can run the project now.

## Contact

Your Name - [arkodeepbiswas] - arkodeep.biswas@nexxo.com

Project Link: [https://github.com/arkodeepbiswas/bankofarko](https://github.com/arkodeepbiswas/bankofarko)

