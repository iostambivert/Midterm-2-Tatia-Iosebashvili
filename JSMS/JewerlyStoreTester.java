import java.io.IOException;

public class JewerlyStoreTester {
    public static void main(String[] args) {
        JewelryStore store = new JewelryStore("Elegant Gems");

        Designer designer1 = new Designer("Tatia Iosebashvili", 10, "Rings");
        Designer designer2 = new Designer("Nikoloz Eriashvili", 5, "Necklaces");

        store.addDesigner(designer1);
        store.addDesigner(designer2);

        System.out.println("List of designers in the store:");
        for (Designer designer : store.listDesigners()) {
            System.out.println(designer);
        }

        System.out.println("List of designers in the store after adding:");
        for (Designer designer : store.listDesigners()) {
            System.out.println(designer);
        }

        // Removing a designer
        store.removeDesigner(designer2);

        System.out.println("\nList of designers in the store after removing Nikoloz Eriashvili:");
        for (Designer designer : store.listDesigners()) {
            System.out.println(designer);
        }

        // Restore state from file
        try {
            store.restoreState();
        } catch (IOException e) {
            System.out.println("Failed to restore state: " + e.getMessage());
        }

        System.out.println("\nList of designers in the store after restoring:");
        for (Designer designer : store.listDesigners()) {
            System.out.println(designer);
        }
    }
}
