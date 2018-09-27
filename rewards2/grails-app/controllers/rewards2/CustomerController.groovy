package rewards2

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import org.grails.datastore.mapping.model.types.Custom
import org.springframework.validation.BindingResult

import static org.springframework.http.HttpStatus.*

@Transactional
class CustomerController {
    static scaffold = Customer

    def calculationsService

    def lookup() {
//        all instances of data that I brought out of the Customer domain

//        def customerInstance = Customer.list(sort: "lastName", order: "asc", max: 5, offset: 0)
//        def customerInstance = Customer.findAllByLastName("Foster")

//        def customerInstance = Customer.findAllByPhone(params.int(id))

//        def customerInstance = Customer.findAllByLastNameIlike("%b%")
//        def customerInstance = Customer.findAllByTotalPointsGreaterThan(3, [sort: "totalPoints", order: "desc"])
//        def customerInstance = Customer.findAllByTotalPointsBetween(2,4, [sort: "totalPoints", order: "desc"])
//        def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsGreaterThan("Bo", 3, [sort: "totalPoints", order: "desc"])

        [customerInstanceList: customerInstance]
    }

    def checkin() {}

    def index() {
        params.max = 10
        def customerInstance = Customer.list(params)
        [customerList : customerInstance,
         customerCount: Customer.count()]
    }

    def create() {
        def newCustomer = new Customer()
        [customer: newCustomer]
    }

    def save(Customer customer) {
        customer.save()
        redirect(action: "show", id: customer.id)
    }

    def show(Long id) {
        def customer = Customer.get(id)
        customer = calculationsService.getTotalPoints(customer)
        [customer: customer]
    }

    def edit(Long id) {
        def customer = Customer.get(id)
        [customer: customer]
    }

    def update(Long id) {
        def customer = Customer.get(id)
        customer.properties = params as BindingResult
        customer.save()

        redirect(action: "show", id: customer.id)
    }

    def delete(Long id) {
        def customer = Customer.get(id)
        customer.delete()

        redirect(actions: "index")
    }

    def customerLookup(Customer lookupInstance) {

        def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)

        render(view: "checkin", model: [customerInstance: customerInstance,
                                        welcomeMessage  : welcomeMessage])

        // Query customer by phone number

        // If there is no result,
        // create new customer
        // Create welcome message - Service
        // Add award record - Service
        // Save customer - Service
        // Send welcome message to kiosk

        // If customer found
        // Calculate how many points they have - Service
        // Create welcome message - Service
        // Add award record - Service
        // Save customer - Service
        // Send welcome message to kiosk

    }

    def profile() {
        def customerInstance = Customer.findByPhone(params.id)

        [customerInstance: customerInstance]
    }

    def updateProfile(Customer customerInstance) {
        customerInstance.save()
        render(view: "profile", model: [customerInstance: customerInstance])
    }
}
