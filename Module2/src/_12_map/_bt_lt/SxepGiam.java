package _12_map._bt_lt;

public class SxepGiam implements java.util.Comparator<Product> {

    @Override
    public int compare(Product product, Product t1) {
        if (t1.getValue() - product.getValue() == 0) {
            return product.getName().compareTo(t1.getName());
        } else return t1.getValue() - product.getValue();
    }
}