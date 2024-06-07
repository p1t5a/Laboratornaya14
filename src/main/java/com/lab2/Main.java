package com.lab2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


class Main {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IGraph graph = context.getBean(IGraph.class);


        Scanner in = new Scanner(System.in);

        // Создание критической секции
        CriticalSection criticalSection = new CriticalSection();

        // Создание потоков
        Thread readerThread = new Thread(() -> {});
        Thread writerThread = new Thread(() -> {});



        while (true) {
            if (!(writerThread.getState() == writerThread.getState().RUNNABLE)) {
            System.out.println("Войти как: \n1. Читатель\n2. Писатель");
            switch (in.nextLine()) {
                case "1":  // Читатель
                    // Проверка, есть ли свободный поток
                    writerThread = new Thread(new GraphReader(graph, criticalSection));
                    writerThread.start();

                    if (!(readerThread.getState() == readerThread.getState().RUNNABLE)) {
                        System.out.println("Введите 0 чтоб начать второй поток читателя");
                        if (in.nextLine() == "0") {
                            readerThread = new Thread(new GraphReader(graph, criticalSection));
                            readerThread.start();
                        }
                    } else {
                        System.out.println("Невозможно получить доступ, все потоки заняты");
                    }

                    break;
                case "2":  // Писатель
                    // Проверка, есть ли свободный поток
                    if (!(readerThread.getState() == readerThread.getState().RUNNABLE)) {

                        writerThread = new Thread(new GraphWriter(graph, criticalSection));

                        writerThread.start();

                    } else {
                        System.out.println("Невозможно получить доступ, все потоки заняты");
                    }
                    break;
                case "exit":
                    // Остановка потоков
                    readerThread.interrupt();
                    writerThread.interrupt();
                    // Закрытие приложения
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод");

                    break;
                }
            }
        }
    }
}
