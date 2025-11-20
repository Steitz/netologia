public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        int value = tail.getValue();
        if (tail != null) {
            tail = tail.getPrev();
            size--;
        }
        return value;
    }

    public int getSize() {
        // ваш код
        return size;  // верните размер стека
    }

    public boolean isEmpty() {
        // ваш код
        return (size == 0);
        // верните ответ на вопрос, не пустой ли стек
    }

    public String toString() {
        if (isEmpty()) return "EMPTY";

        StringBuilder str = new StringBuilder("");

        Node current = tail;
        while (current != null) {
            str.append(current.getValue() + " -> ");
            current = current.getPrev();
        }
        str.delete(str.length() - 3, str.length());
        return str.toString();
    }
}