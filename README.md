# Currency converter
GUI Application for currency converter implemented in Model-View-Controller pattern.

## Functional Requirements
    Implement a program that simulates a currency converter using
    the MVC pattern.

    As an example you can use the official site of BNR:
        http://www.cursbnr.ro/convertor-valutar

    Implementing indications: use JCombobox for selecting the currency.
    Implement three options: RON, EUR, USD.
[Link to the original functional requirements (in romanian)](./Indicatie.png)
## Execution
To start the application, run `Main.java`.

## Modules
> Note: "BNR" prefix is inspired by the actual BNR (National Bank of Romania)
- `BNRModel.java` - small class that holds some constants and calculates the conversion
- `BNRView.java` - implements the graphics for the app
- `BNRController.java` - adds listeners to the graphic components and uses both View and Model Classes to manage the whole application
- `Main.java` - responsible for putting together the Model, View and Controller classes to fulfil MVC architecture.