import java.util.Scanner;
class Book{
    Scanner s = new Scanner(System.in);
    class Entry{
        private String first;
        private String last;
        private String address;
        private String phoneNumber;
        Entry(String first, String last, String address, String phoneNumber){
            this.first = first;
            this.last = last;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }
        Entry(){
            first = "";
            last = "";
            address = "";
            phoneNumber = "";
        }
        public void readEntry(){
            System.out.println("First Name:"+first );
            System.out.println("Last Name:"+last );
            System.out.println("Address:"+address );
            System.out.println("Phone Number:"+phoneNumber );
        }
    }

    private int entries = 0;
    Entry[] contents;
    public void initEntries(int e){
        contents = new Entry[e];
        for (int i = 0;i<contents.length;i++){
            contents[i] = new Entry();
        }
    }
    public int getEntries(){
        return contents.length;
    }
    //Adds an entry to the book
    public void add(String first, String last, String address, String phoneNumber){
        if (entries<contents.length){
        contents[entries] = new Entry(first, last, address, phoneNumber);
        entries++;
        }
        else System.out.println("Error: book is full");
    }

    //Removes an entry from the book
    public void remove(int entry){
        if (entries>0){
            contents[entry] = new Entry();
            for (int i = 0;i<entries-entry;i++){
                if (entry+1==entries) contents[entry] = new Entry();
                else{
                    Entry temp = contents[entry+i];
                    contents[entry+i] = contents[entry+i+1]; //Removes an entry end moves each entry after it one backwards.
                    contents[entry+i+1] = temp;
                }
            }
            entries--;
            }
            else System.out.println("Error: book is empty.");
    }

    //Changes the values of an entry
    public void edit(String first, String last, String address, String phoneNumber, int selection){
        contents[selection].first = first;
        contents[selection].last = last;
        contents[selection].address = address;
        contents[selection].phoneNumber = phoneNumber;
    }

    public void sort(int n){
        for(int i = 0;i<contents.length;i++){
            for (int j = 0;j<contents.length;j++){
                switch(n){
                    case 1:
                        if (contents[i].first.compareTo(contents[j].first)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 2:
                        if (contents[i].last.compareTo(contents[j].last)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 3:
                        if (contents[i].address.compareTo(contents[j].address)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 4:
                        if (contents[i].phoneNumber.compareTo(contents[j].phoneNumber)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    default: 
                        System.out.println("Error: invalid field");
                        break;
                }
            }
        }
    }
}
