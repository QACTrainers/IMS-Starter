Coverage: (tested for individual classes)
# IMS

an inventory management system tracking orders, items and customers

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

in order to use this software you will need to have the following installed

```
java
mysql
```


## Running the tests

Testing in this project is done using junit and mockito, it is automated to test mainly getters.

### Unit Tests 

unit testing is used to test small portions of the code needed to be tested, Such tests have taken place in this project

```
Test to check getter methods return values 
```

### Integration Tests 
integratio tests are to test the functionailty of the code to see different components work together 

```
an exmaple in this project would be to check if the dao works with the controller and domain to create an item in the items table
```

### And coding style tests

this type of testing is used to check if new code, added to existing code works and doesnt break the existing code



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Ed Reynolds for teaching us how to use Git, SQL and basic java; being present when unwell to teach us and help resolve testing errors in my project
* Jordan Harrison for teaching us OOP principles, helping me with my testing errors and access unreachable git files
* The Whole cohort for advising and morally supporting each other through this project. 
