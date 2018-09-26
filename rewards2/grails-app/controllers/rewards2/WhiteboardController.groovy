package rewards2

class WhiteboardController {

   CalculationsService calculationsService

    def index() {}

    def variables() {
        def myTotal = 1
        render("Total: " + myTotal)
        render("</br>" + myTotal.class)

        myTotal = myTotal + 1
        render("New Total: " + myTotal)


        def firstName = "Mike"
        render("</br>Name: " + firstName)
        render("</br>" + firstName.class)


        def today = new Date()
        render("</br>Date: " + today)
        render("</br>" + today.class)

    }

    def strings() {
        def first = "Mike"
        def last = "Kelly"
        def points = 4

        render "Hey there, $first. You already have $points!"
        render "</br>Today is ${new Date()}. </br>Lowercase for firstname is ${first.toLowerCase()}"
    }

    def conditions() {
        def welcomeMessage = calculationsService.welcome(params)
        render welcomeMessage

    }

    def switch1( ) {
        def firstName = "Mike"
        def totalPoints = 3

        def welcomeMessage = ""

        switch (totalPoints) {
            case 5:
                welcomeMessage = "Welcome back, $firstName! This drink is on us!"
                break
            case 4:
                welcomeMessage = "Welcome back, $firstName! Your next drink is free!"
                break
            case 2..3:
                welcomeMessage = "Welcome back, $firstName! You now have $totalPoints points"
                break
            default:
                welcomeMessage = "Welcome, $firstName! Thanks for registering"

        }

        render welcomeMessage
    }
}
