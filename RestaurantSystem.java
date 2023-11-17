
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Locale;

public class RestaurantSystem {

    static TreeNode ItemsRoot = new TreeNode(0, "Menu");
    static Queue<Order> kitchenQueue = new Queue<>();
    static DrinkVendingMachine vendingMachine = new DrinkVendingMachine();
    static Stack<Order>sales=new Stack();

    static int id=0;
    
    private static void FillIMenu() {
        //Kitchen
        TreeNode Appetizers = new TreeNode(2, "Appetizers");
        TreeNode Salads = new TreeNode(3, "Salads");
        TreeNode Burgers = new TreeNode(4, "Burgers");
        TreeNode Pizzas = new TreeNode(5, "Pizzas");
        TreeNode Desserts = new TreeNode(6, "Desserts");
        TreeNode FriedBurgers = new TreeNode(7, "Fried_Burgers");
        TreeNode GrilledBurgers = new TreeNode(8, "Grilled_Burgers");
        ItemsRoot.children.addLast(Appetizers);
        ItemsRoot.children.addLast(Salads);
        ItemsRoot.children.addLast(Burgers);
        ItemsRoot.children.addLast(Pizzas);
        ItemsRoot.children.addLast(Desserts);
        Burgers.children.addLast(FriedBurgers);
        Burgers.children.addLast(GrilledBurgers);

        try {
            File myObj = new File("Items.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Appetizers.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }
            myReader.nextLine();
            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Salads.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }
            myReader.nextLine();
            for (int i = 0; i < 2; i++) {
                String item = myReader.nextLine();
                FriedBurgers.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }
            myReader.nextLine();
            for (int i = 0; i < 3; i++) {
                String item = myReader.nextLine();
                GrilledBurgers.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }
            myReader.nextLine();
            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Pizzas.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }
            myReader.nextLine();
            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Desserts.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("Drinks.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String item = myReader.nextLine();
                switch (item.split(" ")[1]) {
                    case "Cola": {
                        vendingMachine.colaStack.push(new Item(Integer.parseInt(item.split(" ")[0]), "Cola", Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), null));
                        break;
                    }
                    case "Juice": {
                        vendingMachine.juiceStack.push(new Item(Integer.parseInt(item.split(" ")[0]), "Juice", Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), null));
                        break;
                    }
                    case "Water": {
                        vendingMachine.waterStack.push(new Item(Integer.parseInt(item.split(" ")[0]), "Water", Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), null));
                        break;
                    }
                    default:
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    
    //===================================================
    public static void Total_Sales(){ 
        Stack<Order>temp=new Stack();
       float total=0;
       while(!sales.isEmpty())
       {
       
       Order o=sales.pop();
      total+=o.total_cost();
                
       temp.push(o);
       }
           while(!temp.isEmpty())
           sales.push(temp.pop());
           System.out.println("total sales today is : "+total);
        }
   public static void ShowTree(TreeNode Category){
        System.out.println(Category.name + ":\n==================\n");
        if(Category.children.isEmpty()){
            for (int i = 0; i < Category.items.size(); i++) {
                Item t = Category.items.removeFirst();
                System.out.println("\t" + t.getId() + " " + t.getName() + " " + t.getPreparingTime() + "  " + t.getCost() + " " + t.getCount());
                Category.items.addLast(t);
            }
        }
        else{
            for (int i = 0; i < Category.children.size(); i++) {
                TreeNode node = Category.children.removeFirst();
                ShowTree(node);
                Category.children.addLast(node);
            }
        }        
    }
    private static void ReFill(int categoryID, TreeNode root){
      
        if(root.id == categoryID){
            for (int i = 0; i < root.items.size(); i++) {
            Item item = root.items.removeFirst();
            item.setCount(20); 
            root.items.addLast(item);
            }
        }
      
        else{
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode node = root.children.removeFirst();
                ReFill(categoryID, node);
                root.children.addLast(node);
            }
        }}
    //========================================
    
    public static void Dicount(float value, TreeNode Category) {

        if (Category.children.isEmpty()) {
            for (int i = 0; i < Category.items.size(); i++) {
                Item item = Category.items.removeFirst();
                float cost = item.getCost();
                cost *= (1 - value);
                item.setCost(cost);
                Category.items.addLast(item);
            }
        } else {
            for (int i = 0; i < Category.children.size(); i++) {
                TreeNode node = Category.children.removeFirst();
                Dicount(value, node);
                Category.children.addLast(node);
            }
        }
    }

    private static void PriceLow(float value, int categoryID, TreeNode root) {
        if (root.id == categoryID) {
            for (int i = 0; i < root.items.size(); i++) {
                Item item = root.items.removeFirst();
                if (item.getCost() < value) {
                    System.out.println("\t" + item.getId() + " " + item.getName() + " " + item.getPreparingTime() + "  " + item.getCost() + " " + item.getCount());
                }
                root.items.addLast(item);
            }
        } else {
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode node = root.children.removeFirst();
                PriceLow(value, categoryID, node);
                root.children.addLast(node);
            }
        }
    }
    public static void print_All_ordes(){
    
        for(int i=0;i<kitchenQueue.size();i++)
        {
          Order o=kitchenQueue.dequeue();
        
            System.out.println("Order id: "+o.id);
           
             System.out.println("---items order: ---");
           for(int j=0;j<o.items.size();j++)
          {
            Item t=o.items.removeFirst();
              System.out.println("name: "+ t.getName() + " cost: "+t.getCost());
             o.items.addLast(t);
          }
           kitchenQueue.enqueue(o);
        }
        
        }
    
    
    //===============================================
    public static void main(String[] args) {

        FillIMenu();
        ShowTree(ItemsRoot);
     
        Scanner scan = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nChoose an option.\n 1 = make an order,\n 2 = preparing orders, \n 3 = drinks vending machine,\n 4 = close this application.");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    //Create an order
                    Order order = new Order(++id);
                    do {
                        //Show Catogories

                        TreeNode Category = ItemsRoot;
                        while (!Category.children.isEmpty()) {
                            //====== 1- show roote children nodes list
                            for (int i = 0; i < Category.children.size(); i++) {
                                TreeNode node = Category.children.removeFirst();
                                System.out.print(node.id + "-" + node.name + "   ");
                                Category.children.addLast(node);
                            }
                            //===================================ادخال رقم الصنف الرئيسي المطلوب
                            System.out.println();
                            System.out.println("Choose a category number.");
                            choice = scan.nextInt();

                            //=============================== الوصول الى الصنف الرئيسي 
                            TreeNode categoryChoice = Category;
                            for (int i = 0; i < Category.children.size(); i++) {
                                TreeNode node = Category.children.removeFirst();
                                if (node.id == choice) {
                                    categoryChoice = node;
                                }
                                Category.children.addLast(node);
                            }
                            Category = categoryChoice;

                        }

                        //Show Category Items طباعة الاصناف الفرعية 
                        for (int i = 0; i < Category.items.size(); i++) {
                            Item node = Category.items.removeFirst();
                            System.out.print(node.getId() + " - " + node.getName() + " - " + node.getCost() + ",  ");
                            Category.items.addLast(node);
                        }
                        System.out.println();

                        //============================ البحث في ليست العناصر عن العنصر المطلوب
                        Item item = null;
                        int count = 0;
                        System.out.println("Choose an item.");
                        choice = scan.nextInt();
                        for (int i = 0; i < Category.items.size(); i++) {
                            item = Category.items.removeFirst();

                            if (item.getId() == choice) {//اختبار الكمية اذا تسمح بالطلب 
                                System.out.println("the count in menu is**** " + item.getCount());
                                System.out.println("Enter how many item you need ?");
                                count = scan.nextInt();
                                if (item.getCount() >= count) {
                                    item.setCount(item.getCount() - count);

                                    Item CusItm = new Item(item.getId(), item.getName(), item.getPreparingTime(), item.getCost(), count);

                                    //CusItm.setCount(count);
                                    order.items.addLast(CusItm);
                                    System.out.println("the count in menu is **** " + item.getCount());
                                } else {
                                    System.out.println("We are sorry, this item is currently not availble.");
                                }
                            }
                            Category.items.addLast(item);
                        }

                        System.out.println("Add another item? 1 = yes, 0 = no.");

                        choice = scan.nextInt();
                    } while (choice == 1);

                    //////////////////////// Add Drink //////////////////////////////////
                    
                       System.out.println(" DrinK with order ? 1-> yes--- 0-> no");
                    choice = scan.nextInt();
                    if (choice == 1) {
                        do {
                            System.out.println("Choose a drink   1 = juice, 2 = cola, 3 = water.");
                            int n = scan.nextInt();

                            int drcout = 0;
                            System.out.println("how many drink you need?");
                            drcout = scan.nextInt();
                            Stack<Item> drinkStack = null;

                            switch (n) {

                                case 1: {
                                    drinkStack = vendingMachine.juiceStack;
                                    break;
                                }
                                case 2: {
                                    drinkStack = vendingMachine.colaStack;
                                    break;
                                }
                                case 3: {
                                    drinkStack = vendingMachine.waterStack;
                                    break;
                                }
                                default:
                                    System.out.println("Invalid drink!");
                            }
                            if (drinkStack.size() >= drcout) {
                                Item drk = null;
                                for (int i = 0; i < drcout; i++)
                                    drk = drinkStack.pop();                               
                                Item CItm = new Item(drk.getId(), drk.getName(), 0, drk.getCost(), drcout);
                                order.items.addLast(CItm);

                            } else {
                                System.out.println("We are sorry, this drink is currently not availble.");
                            }
                        
                        System.out.println("Order another drink? 1 = yes, 0 = no.");
                        choice = scan.nextInt();
                    } while (choice == 1);
                    }
                    //////////////////////// Add Drink //////////////////////////////////
                    order.printOrder();

                    System.out.println();
                    System.out.println("Total order cost = " + order.total_cost());
                    System.out.println("Total order time = " + order.OrderPreparingTime());
                    kitchenQueue.enqueue(order);
//                    
                    break;
                }               
               

                case 2: {
                    do {
                        if (kitchenQueue.size() > 0) {
                          

                            Order MiniTime = kitchenQueue.first();
                            int size = kitchenQueue.size();
                            for (int i = 0; i < size; i++) {
                                Order o = kitchenQueue.dequeue();
                                if (o.OrderPreparingTime() < MiniTime.OrderPreparingTime()) {
                                    MiniTime = o;
                                }
                                kitchenQueue.enqueue(o);
                            }
                            for (int i = 0; i < size; i++) {
                                Order o = kitchenQueue.dequeue();
                                if (o != MiniTime) {
                                    kitchenQueue.enqueue(o);
                                }
                            }
                            System.out.print("Current order is: "+MiniTime.getId());
                           
                           
                           
                            System.out.println("\nOrder preparing time: " + MiniTime.OrderPreparingTime() + "\n  total cost: " + MiniTime.total_cost());
                            System.out.println();
                        } else {
                            System.out.println("kitchen queue is empty.");
                            break;
                        }
                        System.out.println("Prepare another order? 1 = yes, 0 = no.");
                        choice = scan.nextInt();
                    } while (choice == 1);
                    break;
                }
                //drinks vending machine
                case 3: {
                    do {
                        System.out.println("Choose a drink category. 1 = juice, 2 = cola, 3 = water.");
                        choice = scan.nextInt();
                        int count = 0;
                        System.out.println("Enter drink count you need ");
                        count = scan.nextInt();
                        switch (choice) {
                            case 1: {

                                if (vendingMachine.juiceStack.size() > 0) {
                                    for (int i = 0; i < count; i++) {
                                        vendingMachine.juiceStack.pop();
                                    }

                                }

                                break;
                            }
                            case 2: {
                                if (vendingMachine.colaStack.size() > 0) {

                                    for (int i = 0; i < count; i++) {
                                        vendingMachine.colaStack.pop();
                                    }

                                }
                                break;
                            }
                            case 3: {
                                if (vendingMachine.waterStack.size() > 0) {

                                    for (int i = 0; i < count; i++) {
                                        vendingMachine.waterStack.pop();
                                    }
                                }
                                break;
                            }
                            default:
                                System.out.println("Invalid drink!");
                        }

                        System.out.println("Order another drink? 1 = yes, 0 = no.");
                        choice = scan.nextInt();
                    } while (choice == 1);
                    break;
                }
                default: {
                    if (choice != 4) {
                        System.out.println("Invalid choice!");
                    }
                }
            }
        } while (choice != 4);

      
    }
}
