package Sprint;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList <CostsCalculator> costs = new ArrayList<>();
        printMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 0) {
            if(choice == 1){
                System.out.println("Введите название траты");
                String name = scanner.nextLine();
                System.out.println("Введите сумму затрат");
                Double sum = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Введите категорию затрат");
                String category = scanner.nextLine();
                CostsCalculator newCost = new CostsCalculator(name, sum, category);
                costs.add(newCost);
                System.out.println("\nВыберите пункт меню");
                printMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
            } else if (choice == 2){
                if (costs.isEmpty()){
                    System.out.println("У Вас нет затрат");
                    System.out.println("Выберите пункт меню");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    for(CostsCalculator cost: costs){
                        System.out.println(cost);
                    }
                    System.out.println("\nВыберите пункт меню");
                    printMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } 
            } else if (choice == 3){
                if (costs.isEmpty()){
                    System.out.println("\nВыберите пункт меню");
                    printMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    for(int i = 0; i<costs.size(); i++){
                        System.out.println(i+1 + " " + costs.get(i));
                    }
                    System.out.println("Введите индекс, чтобы удалить затрату");
                    int removeElement = scanner.nextInt();
                    costs.remove(removeElement - 1);
                    System.out.println("Успешное удаление");
                    System.out.println("\nВыберите пункт меню");
                    printMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }

            } else if (choice == 4){
                if(costs.isEmpty()){
                    System.out.println("\nВыберите пункт меню");
                    printMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    printSection();
                    int select = scanner.nextInt();
                    scanner.nextLine();
                    while(select != 0){
                            if (select == 1){
                            double totalSum = 0;
                            for(CostsCalculator cost : costs){
                                totalSum += cost.getAmount();
                            }
                            System.out.println("Итоговая сумма = " + totalSum);
                            System.out.println("\nВыберите раздел");
                            printSection();
                            select = scanner.nextInt();
                            scanner.nextLine();
                        } else if (select == 2){
                            double totalSum = 0;
                            for (CostsCalculator cost: costs){
                                totalSum += cost.getAmount();
                            } double avgSum = totalSum / costs.size();
                            System.out.println("Средняя сумма расходов = " + avgSum);
                            System.out.println("\nВыберите раздел");
                            printSection();
                            select = scanner.nextInt();
                            scanner.nextLine();
                        } else if (select == 3){
                            System.out.println(costs);
                            for(CostsCalculator cost: costs){
                                System.out.println(cost.getCategory());
                            }
                            System.out.println("Выберите категорию");
                            String selectCategory = scanner.nextLine();
                            double totalSum = 0;
                            for (CostsCalculator cost: costs){
                                if (cost.getCategory().equals(selectCategory)){
                                    totalSum += cost.getAmount();
                                }
                            }
                            System.out.println("Итоговая сумма по категориям " + totalSum);
                            printSection();
                            select = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }       System.out.println("\nВыберите пункт меню");
                            printMenu();
                            choice = scanner.nextInt();
                            scanner.nextLine();
                }

            } else if (choice == 5){
                System.out.println("Работа с программой завершена");
                System.exit(0);
            }     
        }
     }

     public static void printMenu(){ 
        System.out.println("=== Калькулятор расходов===");
        System.out.println("1. Добавить трату");
        System.out.println("2. Показать все траты");
        System.out.println("3. Удалить трату");
        System.out.println("4. Статистика");
        System.out.println("5. Выход");
    }

    public static void printSection(){
        System.out.println("Выберите раздел");
        System.out.println("1. Общая сумма всех затрат");
        System.out.println("2. Средний расход");
        System.out.println("3. Сумма по категориям");
        System.out.println("0. Выход из раздела");
    }
}


