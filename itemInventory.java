import java.util.Scanner;
class itemInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int itemNumbers[] = new int[10];
        double itemPrices[] = new double[10];
        int count = 0;
        System.out.println("Enter 10 item numbers and their prices:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Item number " + (i + 1) + ": ");
            itemNumbers[i] = sc.nextInt();
            System.out.print("Price: ");
            itemPrices[i] = sc.nextDouble();
            count++;
        }
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add an item");
            System.out.println("2. List all items");
            System.out.println("3. Search for an item");
            System.out.println("4. Modify an item");
            System.out.println("5. Delete an item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (count < 10) {
                        System.out.print("Enter new item number: ");
                        itemNumbers[count] = sc.nextInt();
                        System.out.print("Enter price: ");
                        itemPrices[count] = sc.nextDouble();
                        count++;
                        System.out.println("Item added.");
                    } else {
                        System.out.println("Inventory full. Cannot add more items.");
                    }
                    break;
                case 2:
                    System.out.println("Item Number\tPrice");
                    for (int i = 0; i < count; i++) {
                        System.out.println(itemNumbers[i] + "\t\t" + itemPrices[i]);
                    }
                    break;
                case 3:
                    System.out.print("Enter item number to search: ");
                    int searchNum = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (itemNumbers[i] == searchNum) {
                            System.out.println("Item found: Price = " + itemPrices[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter item number to modify: ");
                    int modifyNum = sc.nextInt();
                    found = false;
                    for (int i = 0; i < count; i++) {
                        if (itemNumbers[i] == modifyNum) {
                            System.out.print("Enter new price: ");
                            itemPrices[i] = sc.nextDouble();
                            System.out.println("Price updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter item number to delete: ");
                    int deleteNum = sc.nextInt();
                    found = false;
                    for (int i = 0; i < count; i++) {
                        if (itemNumbers[i] == deleteNum) {
                            for (int j = i; j < count - 1; j++) {
                                itemNumbers[j] = itemNumbers[j + 1];
                                itemPrices[j] = itemPrices[j + 1];
                            }
                            count--;
                            System.out.println("Item deleted.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
        sc.close();
    }
}