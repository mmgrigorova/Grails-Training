package rewards2

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {

    def welcome(int totalPoints, String firstName) {
        def welcomeMessage = ""

        if (totalPoints >= 5) {
            welcomeMessage = "Welcome back, $firstName! This drink is on us!"
        } else if (totalPoints == 4) {
            welcomeMessage = "Welcome back, $firstName! Your next drink is free!"
        } else {
            welcomeMessage = "Welcome back, $firstName! You now have $totalPoints points"
        }

        return welcomeMessage
    }

    Customer getTotalPoints(Customer customer) {
        def totalAwards = 0

        // Use the name we assigned to then field in the hasMany relationship - "awards"
        customer.awards.each {
            totalAwards = totalAwards + it.points
        }
        customer.totalPoints = totalAwards

        return customer
    }

    def processCheckin(Customer lookupInstance) {

        // Lookup customer by phone

        def customerInstance = Customer.findByPhone(lookupInstance.phone)

        // Set up new customer

        if (customerInstance == null) {
            customerInstance = lookupInstance
            customerInstance.firstName = "Customer"
        }

        // Calculate current award points

        customerInstance = getTotalPoints(customerInstance)

        def totalPoints = customerInstance.totalPoints

        // Add new award
        if (totalPoints < 5) {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }

        // Create welcome message
        def welcomeMessage = welcome(totalPoints, customerInstance.firstName)


        // Save customer
        customerInstance.save()

        return [customerInstance, welcomeMessage]
    }
}
