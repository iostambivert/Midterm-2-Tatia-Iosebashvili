import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JewelryStore {
    private String storeName;
    private List<Designer> designers;

    // Constructor
    public JewelryStore(String storeName) {
        this.storeName = storeName;
        this.designers = new ArrayList<>();
    }

    // Method to add a designer
    public void addDesigner(Designer designer) {
        if (designer != null) {
            designers.add(designer);
        } else {
            throw new IllegalArgumentException("Designer cannot be null");
        }
    }

    public void removeDesigner(Designer designer) {
        if (designer != null) {
            designers.remove(designer);
        } else {
            throw new IllegalArgumentException("Designer cannot be null");
        }
    }

    // Method to list all designers
    public List<Designer> listDesigners() {
        return designers;
    }

    public void saveState() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Designer designer : designers) {
                writer.write(designer.toCSV());
                writer.newLine();
            }
        }
    }

    public void restoreState() throws IOException {
        designers.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                designers.add(Designer.fromCSV(line));
            }
        }
    }

    // toString method
    @Override
    public String toString() {
        return "JewelryStore{" +
                "storeName='" + storeName + '\'' +
                ", designers=" + designers +
                '}';
    }

}
