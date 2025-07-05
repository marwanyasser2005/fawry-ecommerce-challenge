     public class ExpirableProduct extends Product {
         private boolean isExpirable;

         public ExpirableProduct(String name, double price, int quantity) {
             super(name, price, quantity);
             this.isExpirable = true;
         }

         public boolean isExpirable() {
             return isExpirable;
         }
     }