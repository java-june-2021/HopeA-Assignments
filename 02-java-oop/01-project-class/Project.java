public class Project {
    public String name;
    public String description;


    public String elevatorPitch() {
        return "Name: " + this.name + ":" + "Description: " + this.description;

    }

    public Project() {
        this.name = "My name";
        this.description = "My description";
    }

    public Project(String name) {
        this.name = name;
        this.description = "My description";
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}