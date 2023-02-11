package testing;

import bst1.BinarySearchTree;

import bst1.Comparable;

public class Test 
{
    public static class Person implements Comparable<Person>
    {
        private String name;

        public Person(String name)
        {
            this.name = name;
        }

        @Override
        public int compareTo(Person other)
        {
            return name.compareTo(other.name);
        }

        @Override
        public String toString()
        {
            return name;
        }
    } 

    public static void main(String[] args)
    {
        test1();
    }

    public static void test1()
    {
        Person[] people = new Person[]
        {
            new Person("Mars"),
            new Person("Kiste"),
            new Person("Zoo"),
            new Person("23"),
            new Person("#"),
            new Person("aa"),
            new Person("Zement"),
            new Person("Zebra"),
            new Person("Iglu"),
            new Person("Kuchen"),
            new Person("Johannisbeere"),
            new Person("Dreitausendfünfhundertvierundzwanzig"),
        };

        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();

        for (Person person : people) tree.insert(person);

        System.out.println(tree);

        tree.remove(people[0]);

        System.out.println(tree);
    }

    public static void test2()
    {
        BinarySearchTree<Person> tree = generateRandomTree(100, 2);

        System.out.println(tree);

        tree.remove(new Person("aa"));

        System.out.println(tree);
    }

    public static BinarySearchTree<Person> generateRandomTree(int elements, int nameLength)
    {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();

        for (int i = 0; i < elements; i++) tree.insert(new Person(generateRandomString(nameLength)));

        return tree;
    }

    public static String generateRandomString(int nameLength)
    {
        String result = "";

        for (int i = 0; i < nameLength; i++) result += (char) (Math.random() * 26 + 'a');

        return result;
    }
}
