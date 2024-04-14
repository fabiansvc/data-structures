import model.dequeue.Dequeue;
import model.dequeue.IDequeue;
import model.list.IList;
import model.list.LinkedList;
import model.queues.IQueue;
import model.queues.Queue;
import model.stack.IStack;
import model.stack.Stack;
import model.tables.ITable;
import model.tables.Table;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //exampleStack();
        //exampleQueues();
        //exampleList();
        //exampleDequeue();
        //exampleTable();
        exampleArrayList();
    }

    private static void exampleStack(){
        Stack<Integer> stack = new Stack<>();
         stack.push(1);
         stack.push(2);
         stack.push(3);

         System.out.println("Size of the stack: " + stack.size());
         System.out.println("Element at the top: " + stack.peek());
         System.out.println("Popping an element:");
         stack.pop();
         System.out.println("Size of the stack after pop: " + stack.size());
         System.out.println("Is the stack empty? " + stack.isEmpty());
         System.out.println("Creating a deep copy of the stack:");
         IStack<Integer> copyStack = stack.deepCopy();
         System.out.println("Size of the copy stack: " + copyStack.size());
         System.out.println("Element at the top of the copy stack: " + copyStack.peek());
    }

    private static void exampleQueues(){

        int size = 10;
        System.out.println(size++);
        System.out.println(size);
        Queue<Integer> queue = new Queue<>();

        // Add elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        // Display the size of the queue
        System.out.println("Queue size: " + queue.size());

        // Display and remove the front element of the queue
        System.out.println("Front element of the queue: " + queue.front());
        queue.dequeue();

        // Display the size of the queue after dequeue
        System.out.println("Queue size after dequeue: " + queue.size());

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());

        // Create a deep copy of the queue
        IQueue<Integer> copyQueue = queue.deepCopy();

        // Display the size of the copied queue
        System.out.println("Size of the copied queue: " + copyQueue.size());

        // Display and remove the front element of the copied queue
        System.out.println("Front element of the copied queue: " + copyQueue.front());
        copyQueue.dequeue();
    }

    private static void exampleList(){
        // Create a linked list of integers
        IList<Integer> list = new LinkedList<>();

        // Add elements to the list
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(4);

        // Display the initial content of the list
        System.out.println("Initial List:");
        printList(list);

        // Get the first and last element
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Remove the first element
        list.removeFirst();
        System.out.println("List after removing the first element:");
        printList(list);

        // Check if the list contains a specific element
        System.out.println("Does the list contain the number 2? " + list.contains(2));

        // Remove a specific element
        list.removeElementByIndex(1); // Specify the type explicitly to resolve ambiguity
        System.out.println("List after removing the number 1 :");
        printList(list);

        // Clear the list
        list.clear();
        System.out.println("List after clearing:");
        printList(list);
    }

    private static void exampleDequeue(){
        IDequeue<Integer> dequeue = new Dequeue<>();

        // Add elements to the front and back of the dequeue
        dequeue.addFirst(1);
        dequeue.addLast(2);
        dequeue.addLast(3);

        // Display the dequeue
        System.out.println("Dequeue: " + dequeue);

        // Get the first and last elements
        System.out.println("First element: " + dequeue.getFirst());
        System.out.println("Last element: " + dequeue.getLast());

        // Remove the first and last elements
        dequeue.removeFirst();
        dequeue.removeLast();

        // Display the dequeue after removal
        System.out.println("Dequeue after removal: " + dequeue);

        // Check if the dequeue contains an element
        System.out.println("Does the dequeue contain 2? " + dequeue.contains(2));

        // Create a deep copy of the dequeue
        IDequeue<Integer> copyDequeue = dequeue.deepCopy();

        // Display the copied dequeue
        System.out.println("Copied dequeue: " + copyDequeue);
    }

    private static void exampleTable(){
        // Crear una tabla para mapear nombres a edades
        ITable<String, Integer> personTable = new Table<>();

        // Añadir algunas personas a la tabla
        personTable.set("Alice", 30);
        personTable.set("Bob", 25);
        personTable.set("Charlie", 35);

        // Obtener la edad de Alice
        System.out.println("Alice's age: " + personTable.get("Alice"));

        // Comprobar si la tabla contiene a Bob
        System.out.println("Does the table contain Bob? " + personTable.contains("Bob"));

        // Eliminar a Charlie de la tabla
        personTable.remove("Charlie");

        // Mostrar el tamaño de la tabla después de la eliminación
        System.out.println("Table size after removal: " + personTable.size());

        // Crear una copia profunda de la tabla
        ITable<String, Integer> copyTable = personTable.deepCopy();

        // Mostrar la copia de la tabla
        System.out.println("Copy of the table: " + copyTable);

        // Obtener la lista de claves de la tabla original
        IList<String> keys = personTable.keyList();
        System.out.println("Keys in the original table: " + keys);
    }

    private static void exampleArrayList(){
        // Create an ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the end of the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(20);
        numbers.add(30);

        // Insert an element at a specific position
        numbers.add(1, 15);

        // Get an element at a specific position
        int elementAtIndex2 = numbers.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2);

        // Replace an element at a specific position
        numbers.set(0, 5);

        // Remove an element at a specific position
        numbers.remove(3);

        // Remove the first occurrence of the element 20
        numbers.remove(Integer.valueOf(20));

        for(int elem : numbers){
            System.out.println(elem);
        }

        // Check if the ArrayList is empty
        boolean isEmpty = numbers.isEmpty();
        System.out.println("Is the ArrayList empty? " + isEmpty);

        // Get the size of the ArrayList
        int size = numbers.size();
        System.out.println("Size of the ArrayList: " + size);

        // Check if the ArrayList contains an element
        boolean contains30 = numbers.contains(30);
        System.out.println("Does the ArrayList contain 30? " + contains30);

        // Get the index of the first occurrence of the element 10
        int indexOf10 = numbers.indexOf(10);
        System.out.println("Index of the first occurrence of 10: " + indexOf10);

        // Get the index of the last occurrence of the element 10
        int lastIndexOf10 = numbers.lastIndexOf(10);
        System.out.println("Index of the last occurrence of 10: " + lastIndexOf10);

        // Clear all elements from the ArrayList
        numbers.clear();
    }

    // Helper method to print the content of the list
    private static void printList(IList<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

}
