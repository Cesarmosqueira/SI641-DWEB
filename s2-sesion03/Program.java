package org.example.application;

import org.example.entities.Product;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        List<Product> products =Util.getProducts();

        getFilterProductGroupingByStock(products);

    }

    public static Map<Integer, List<Product>> getFilterProductGroupingByStock(List<Product> products){

        //Java <8
        //List<Type>
        List<Product> productsStock20=new ArrayList<>();
        for (Product product:products) {
            if(product.getUnitsIntStock()>20){
                productsStock20.add(product);
            }
        }

        //Java 8 > API Stream == Flujos de datos
        Map<Integer, List<Product>> result= products.stream()//Stream<Type>-->Stream<Product>
                .filter(p->p.getUnitsIntStock()<20)//Stream<Product>
                .collect(Collectors.groupingBy(Product::getUnitsIntStock));

        //Map<Integer, List<Product>>
        //Stock   - Productos
        //30      - P1,P2,P3
        //20      - P4,P5

        return result;
    }


    public static List<String> functionMap(List<Integer> numbers){

        Function<Integer,Integer> multiplyBy2=number->number*2;
        Function<Integer,String> transformNumberString=number->String.valueOf(number);


        List<String> numbersAsString=numbers.stream()
                .map(multiplyBy2)//Stream<Integer>
                .map(transformNumberString)//Stream<String>
                .collect(Collectors.toList());//List<String>

        return numbersAsString;
    }
}
