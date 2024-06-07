package com.lab2;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalSection {
    private ReentrantLock lock = new ReentrantLock();
    private int readerCount;
    private int writerCount;

    public CriticalSection() {
        readerCount = 0;
        writerCount = 0;
    }

    public boolean readerEnter() {
        lock.lock();
        try {
            if (writerCount > 0) {
                System.out.println("Доступ читателю запрещён, граф редактируется");
                return false;
            }
            readerCount++;
            System.out.println("Доступ читателю разрешён");
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean writerEnter() {
        lock.lock();
        try {
            if (readerCount > 0 || writerCount > 0) {
                System.out.println("Доступ писателю запрещён, граф используется");
                return false;
            }
            writerCount++;
            System.out.println("Доступ писателю разрешён");
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean readerExit() {
        lock.lock();
        try {
            readerCount--;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean writerExit() {
        lock.lock();
        try {
            writerCount--;
            return true;
        } finally {
            lock.unlock();
        }
    }
}