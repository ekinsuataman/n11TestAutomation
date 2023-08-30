# N11 TEST AUTOMATION

---
This project is a test automation project for n11.com. Java-Selenium is used to prepare the project. It contains 3 different features that contain scenarios written Gherkin syntax as below; 

### Feature - 1 - Check Navigating to Store Page from All Stores

* Visit www.n11.com/magazalar
* Click "Tüm Mağazalar" button
* Filter stores whose first letter is "S"
* Click a random store and confirm that it land the store's page

### Feature - 2 - Check Searching an Item and Add Basket to Buy
* Visit www.n11.com and write the "iPhone" to search bar and search
* Add basket to first and the last items of the result
* Go to basket and move to payment page a guest user
* Ensure that it routes to payment page

### Feature - 3 - Check Searcing an Item and Filter According to Comments and Shipping Options
* Visit www.n11.com and write the "Telefon" to search bar and search
* Choose second brand from filter options
* Order the results according to comments
* Ensure that the order is correct
* Filter the results for free shipping
* Ensure that all the results are valid for free shipping

