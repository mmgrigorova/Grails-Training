package rewards2

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
        def firstName = params.first
        def totalPoints = params.int('points')


        def welcomeMessage = ""

        if (totalPoints >= 5) {
            welcomeMessage = "Welcome back, $firstName! This drink is on us!"
        } else if (totalPoints == 4) {
            welcomeMessage = "Welcome back, $firstName! Your next drink is free!"
        } else {
            welcomeMessage = "Welcome back, $firstName! You now have $totalPoints points"
        }

    }
}
