public class SingleLinkedList {
    public static class Node<E> {

        public E data;

        public Node<E> next;

        public Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        public Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }


    public static class KWSingleLinkedList<E> {
        public Node<E> head = null;
        public int size = 0;

        public void addFirst(E item) {
            head = new Node<>(item, head);
            size++;
        }

        public void addAfter(Node<E> node, E item) {
            node.next = new Node<>(item, node.next);
            size++;
        }

        public E removeAfter(Node<E> node) {
            Node<E> temp = node.next;
            if (temp != null) {
                node.next = temp.next;
                size--;
                return temp.data;
            } else {
                return null;
            }
        }
        public E removeFirst() {
            Node<E> temp = head;
            if (head != null) {
                head = head.next;
            }
            if (temp != null) {
                size--;
                return temp.data;
            } else {
                return null;
            }
        }
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node<E> current = head;
            while (current != null) {
                result.append(current.data).append(" -> ");
                current = current.next;
            }
            result.append("null");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        KWSingleLinkedList list = new KWSingleLinkedList();

        list.addFirst("cike");
        list.addFirst("cika");
        list.addFirst("cobi");

        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
    }
}