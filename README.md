# JavaSeliniumMaven
mvn clean test -DsuiteXmlFile=testng.xml // clean and Test Jinkin gole

WebTable
how to find webTable all elements in java selenium  
To find all elements of a web table using Java Selenium, you can follow these steps:

Identify the web table on the webpage using any of the available locators such as ID, name, class name, or xpath.

Once you have identified the web table, you can get all the rows of the table using the 
findElements() method and specifying the tag name of the table rows (<tr>).

less
Copy code
WebElement table = driver.findElement(By.id("table_id"));
List<WebElement> rows = table.findElements(By.tagName("tr"));
Loop through the rows of the table and get all the columns of each row using the 
  findElements() method and specifying the tag name of the table columns (<td>).

sql
Copy code
for (WebElement row : rows) {
    List<WebElement> cols = row.findElements(By.tagName("td"));
    // Perform actions on each column of the row
}
You can then perform any desired actions on the individual elements (cells) of the table by looping through the columns of each row.

Here's an example code snippet that demonstrates how to get all the elements of a web table and print their text:

less
Copy code
WebElement table = driver.findElement(By.id("table_id"));
List<WebElement> rows = table.findElements(By.tagName("tr"));
for (WebElement row : rows) {
   List<WebElement> cols = row.findElements(By.tagName("td"));
   for (WebElement col : cols) {
       System.out.println(col.getText());
   }
}







