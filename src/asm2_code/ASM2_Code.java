/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm2_code;
import java.util.Scanner;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (front == null) {
            return null;
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class ASM2_Code {

    public static void main(String[] args) {
        Queue messageQueue = new Queue();
        Stack messageStack = new Stack();

        // Input messages
        Scanner scanner = new Scanner(System.in);
        String inputMessage;

        do {
            System.out.print("Enter the string (max 250 characters) or 'exit' to stop: ");
            inputMessage = scanner.nextLine();

            if (!inputMessage.equalsIgnoreCase("exit")) {
                if (inputMessage.length() <= 250) {
                    messageQueue.enqueue(inputMessage);
                } else {
                    System.out.println("Error: The message should not exceed 250 characters.");
                }
            }
        } while (!inputMessage.equalsIgnoreCase("exit"));

        // Send Message (Dequeue from Queue, Push to Stack)
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.dequeue();
            messageStack.push(message);
        }

        // Received message / View message (Print out messages currently in the stack)
        System.out.println("Messages in the Stack:");
        while (!messageStack.isEmpty()) {
            System.out.println(messageStack.pop());
        }
    }
    
}
