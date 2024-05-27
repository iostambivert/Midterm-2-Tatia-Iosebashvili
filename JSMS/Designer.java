public class Designer {
    private String name;
    private String specialty;
    private int experienceYears;


    // Constructor
    public Designer(String name, int experienceYears, String specialty) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.specialty = specialty;
    }

    // Getters
    public String getName() {
        return name;
    }

    public void setName(String name){this.name=name;}



    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }


    public String getspecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String toCSV() {
        return name + "," + experienceYears + "," + specialty;
    }

    public static Designer fromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid CSV format");
        }
        return new Designer(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }

    // toString method
    @Override
    public String toString() {
        return "Designer{" +
                "name='" + name + '\'' +
                ", experienceYears=" + experienceYears +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
