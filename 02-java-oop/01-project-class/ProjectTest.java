public class ProjectTest {
    public static void main(String[] args) {
        Project pro1 = new Project();
        pro1.name = "test";
        pro1.description = "test";
        System.out.println(pro1.getName());
        System.out.println(pro1.getDescription());
        System.out.println(pro1.elevatorPitch());

        Project pro2 = new Project("test");
        System.out.println(pro2.getName());
        System.out.println(pro2.getDescription());
        System.out.println(pro2.elevatorPitch());

        Project pro3 = new Project("test", "test");
        pro3.setName("new test name");
        System.out.println(pro3.getName());
        pro3.setName("new test description");
        System.out.println(pro3.getDescription());
        System.out.println(pro3.elevatorPitch());

        
    }
}