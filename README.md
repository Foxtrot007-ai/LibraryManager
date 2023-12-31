# LibraryManager
Library manager app for small local library.

Made with Java swing and Mysql data base.

Data Base name is hardcoded as librarydatabase in src/LibraryManager/LibraryApplication.java

DataBaseConnector class connects to MySql Data Base on port 3306 and has functions for different Window UIs.

Other classes implement UI, like forms for user/book add or delete.

**(NEW)** 

DataBaseConnectorProxy uses Proxy pattern to made send sql insert queries when user adds/removes users/books/rentals. 
It's made by override base methods and using base methods with keyword super.

# Examples:

### Attempt to log in to the database
<p align="center">
  <img src="https://github.com/Foxtrot007-ai/LibraryManager/blob/main/Screenshots/Screenshot_4.png"  >
</p> 

### Adding User
<p align="center">
  <img src="https://github.com/Foxtrot007-ai/LibraryManager/blob/main/Screenshots/Screenshot_1.png"  >
</p> 

### Adding User with same Pesel Error Example
<p align="center">
  <img src="https://github.com/Foxtrot007-ai/LibraryManager/blob/main/Screenshots/Screenshot_2.png"  >
</p> 

### Renting book for 14 days by user with ID 8
<p align="center">
  <img src="https://github.com/Foxtrot007-ai/LibraryManager/blob/main/Screenshots/Screenshot_5.png"  >
</p> 

### Change History (NEW)
<p align="center">
  <img src="https://github.com/Foxtrot007-ai/LibraryManager/blob/main/Screenshots/Screenshot_6.png"  >
</p> 
