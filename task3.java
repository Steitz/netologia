import java.util.Scanner;
public class Main {
    public static double calculateCustoms (int vPrice, int vWeight){
        double res = vPrice*0.01+vWeight*100;
        return res;
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print ( "Введите цену товара (в руб.):");
        int price = scanner.nextInt();
        System.out.print ( "Введите вес товара (в кг):");
        int weight = scanner.nextInt();
        double tax = calculateCustoms(price,weight);
        System.out.println ( "Размер пошлины (в руб.) составит: "+tax);
    }
}
