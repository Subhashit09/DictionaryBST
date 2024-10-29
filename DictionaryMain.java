import java.util.Scanner;

public class DictionaryMain {
    public static void main(String[] args) {
        DictionaryBST dictionary = new DictionaryBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDictionary Operations:");
            System.out.println("1. Add keyword");
            System.out.println("2. Search keyword");
            System.out.println("3. Update keyword");
            System.out.println("4. Display in ascending order");
            System.out.println("5. Display in descending order");
            System.out.println("6. Delete keyword");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter keyword: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter meaning: ");
                    String value = scanner.nextLine();
                    dictionary.insert(key, value);
                    break;
                case 2:
                    System.out.print("Enter keyword to search: ");
                    key = scanner.nextLine();
                    Node result = dictionary.search(key);
                    if (result != null) {
                        System.out.println(key + ": " + result.value);
                    } else {
                        System.out.println("Keyword '" + key + "' not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter keyword to update: ");
                    key = scanner.nextLine();
                    System.out.print("Enter new meaning: ");
                    value = scanner.nextLine();
                    dictionary.update(key, value);
                    break;
                case 4:
                    dictionary.displayAscending();
                    break;
                case 5:
                    dictionary.displayDescending();
                    break;
                case 6:
                    System.out.print("Enter keyword to delete: ");
                    key = scanner.nextLine();
                    dictionary.delete(key);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
