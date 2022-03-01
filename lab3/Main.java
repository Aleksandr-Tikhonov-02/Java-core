package lab3;

import lab3.hordovie.*;

public class Main {
    public static void main(String[] args) {
        MyQueue<?>[] array;
        array = consume(produce(50));
        System.out.println("Array 0 is empty: " + array[0].empty());
        System.out.println("Array 1 is empty: " + array[1].empty());
        System.out.println("Array 2 is empty: " + array[2].empty());
        System.out.println("Array 0 size is: " + array[0].size());
        System.out.println("Array 1 size is: " + array[1].size());
        System.out.println("Array 2 size is: " + array[2].size());
        System.out.println("Array 0:");
        System.out.println(array[0]);
        System.out.println("Array 1:");
        System.out.println(array[1]);
        System.out.println("Array 2:");
        System.out.println(array[2]);
    }

    public static MyQueue<? extends Hordovie> produce(int size) {
        MyQueue<Hordovie> queue = new MyQueue<>(size);
        int randNum;
        for (int i = 0; i < size; i++) {
            randNum = (int)(Math.random() * 16 + 1);
            switch(randNum) {
                case 1 -> queue.add(new Ascidii());
                case 2 -> queue.add(new Beschelustnie());
                case 3 -> queue.add(new Bescherepnie());
                case 4 -> queue.add(new Chelustnorotie());
                case 5 -> queue.add(new Chetveronogie());
                case 6 -> queue.add(new Diapsidi());
                case 7 -> queue.add(new Dinozavri());
                case 8 -> queue.add(new Hordovie());
                case 9 -> queue.add(new Lancetniki());
                case 10 -> queue.add(new Minogi());
                case 11 -> queue.add(new Obolochniki());
                case 12 -> queue.add(new Pozvonochnie());
                case 13 -> queue.add(new Presmikaushiesya());
                case 14 -> queue.add(new Ptici());
                case 15 -> queue.add(new Yasheri());
                case 16 -> queue.add(new Zemnovodnie());
            }
        }
        return queue;
    }

    public static MyQueue<?>[] consume(MyQueue<? extends Hordovie> producedQueue) {
        int size = producedQueue.size();
        MyQueue<Hordovie> queueSuperLancetnici = new MyQueue<>(size);
        MyQueue<Hordovie> queueSuperAscidii = new MyQueue<>(size);
        MyQueue<Hordovie> queueSuperDiapcidi = new MyQueue<>(size);
        for (int i = 0; i < size; i++) {
            Class<? extends Hordovie> element = producedQueue.get().getClass();
            if(checkIfExtends((Lancetniki.class), element)) {
                queueSuperLancetnici.add(producedQueue.remove());
                continue;
            }
            if (checkIfExtends((Ascidii.class), element)) {
                queueSuperAscidii.add(producedQueue.remove());
                continue;
            }
            if (checkIfExtends((Diapsidi.class), element)) {
                queueSuperDiapcidi.add(producedQueue.remove());
                continue;
            }
            producedQueue.remove();
        }
        MyQueue<?>[] array = new MyQueue<?>[3];
        array[0] = queueSuperLancetnici;
        array[1] = queueSuperAscidii;
        array[2] = queueSuperDiapcidi;
        return array;
    }
    private static boolean checkIfExtends(Class<? extends Hordovie> extended, Class<? extends Hordovie> checked) {
        Class <?> tmpCl = extended;
        while (tmpCl.getSuperclass() != Object.class) {
            if (checked.equals(tmpCl)) {
                return true;
            }
            tmpCl = tmpCl.getSuperclass();
        }
        return false;
    }

}
