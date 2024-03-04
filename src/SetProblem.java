import java.util.HashSet;
import java.util.Set;

// to resolve this problem we have to override the equals and hashcode functions
public class SetProblem {

    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            final User other = (User) obj;
            if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
                return false;
            }

            if (this.age != other.age) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = 5;
            //if field is an object
            result = 53 * result + (this.name != null ? this.name.hashCode() : 0);
            //if field is byte, char, short, int
            result = 53 * result + this.age;
            return result;
        }
    }

    public static void main(String[] args) {

        Set<User> users = new HashSet<>();

        users.add(new User("Max", 27));
        users.add(new User("Veronika", 20));
        users.add(new User("Denis", 30));
        users.add(new User("Max", 27));

        if (users.size() == 3) {
            System.out.println("System works well!");
        } else {
            throw new RuntimeException("Users set size should be 3!");
        }
    }
}

