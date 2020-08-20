import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("How many books do you want to create? ");
        int howManyBooks;
        int howManyEntries;

        Book[] library = new Book[0];


        while(true){
            howManyBooks = s.nextInt();
            if (howManyBooks>0){
                library = new Book[howManyBooks];
                break;
            }
            else System.out.print("You must create at least 1 book.");
            }



        for (int i=0;i<library.length;i++){


            library[i] = new Book(); 

            while(true){
                System.out.print("How many entries in book "+i+"? ");
                howManyEntries = s.nextInt();
                if (howManyEntries>0) {
                    library[i].initEntries(howManyEntries);
                    break;
                }
                else System.out.println("You must create at least 1 Entry.");
                }


        }
        boolean done = false;
        int selectedBook = 0;
        int selection;
        while (done==false){
            System.out.println("Book "+selectedBook+" is currently selected.");

            for (int i = 0;i<library[selectedBook].getEntries();i++){
                System.out.println("________________Entry "+i+" _____________");
                library[selectedBook].contents[i].readEntry(); 
                System.out.println("__________________________________________");
            }
            System.out.println("Select an option!");
            System.out.println("1. Add an entry");
            System.out.println("2. Remove an entry");
            System.out.println("3. Edit an entry");
            System.out.println("4. Sort all entries in this book");
            System.out.println("5. Select another book");
            System.out.println("6. Exit the menu");
            System.out.print("> ");
            selection = s.nextInt();
            String first, last, address, phoneNumber;
            switch(selection){
            case 1: 
                System.out.print("First name? ");
                first = s.next();
                System.out.print("Last name? ");
                last = s.next();
                System.out.print("Address? ");
                address = s.next();
                System.out.print("Phone Number? ");
                phoneNumber = s.next();
                library[selectedBook].add(first, last, address, phoneNumber);
                break;
            case 2: 
                System.out.print("Remove which entry? ");
                int entry = s.nextInt();
                library[selectedBook].remove(entry);
                break;
            case 3:
                System.out.print("Edit which entry?");
                int whichEntry = s.nextInt();
                System.out.print("First name? ");
                first = s.next();
                System.out.print("Last name? ");
                last = s.next();
                System.out.print("Address? ");
                address = s.next();
                System.out.print("Phone Number? ");
                phoneNumber = s.next();
                library[selectedBook].edit(first, last, address, phoneNumber, whichEntry);
                break;
            case 4: 
                System.out.println("Sort alphabetically by which field?");
                System.out.println("1. Sort by first name");
                System.out.println("2. Sort by last name");
                System.out.println("3. Sort by address");
                System.out.println("4. Sort by phone number");
                library[selectedBook].sort(s.nextInt());
                break;
            case 5: 
                System.out.print("Select which book?");
                selectedBook = s.nextInt();
                break;
            case 6:
                done = true;
                break;
            default:
                System.out.print("Please choose a valid menu number");

            }

        }
    }
}
