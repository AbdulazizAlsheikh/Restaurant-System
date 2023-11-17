/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class Stack<E>
{
    LinkedList<E>list=new LinkedList<>();
    public Stack(){}
    public int size(){return list.size();}
    public boolean isEmpty(){return list.isEmpty();}
    public void push(E element){list.addFirst(element);}
    public E top(){return list.first();}
    public E pop(){return list.removeFirst();}   
     
}
