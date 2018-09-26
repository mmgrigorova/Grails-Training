package rewards2

class BootStrap {

    def init = { servletContext ->
        new rewards2.Product(name: "Morning Blend", sku: "MB01", price: 14.95).save()
        new rewards2.Product(name: "Dark Roast", sku: "DK01", price: 12.95).save()
    }
    def destroy = {
    }
}
