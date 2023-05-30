/*
Итоговое домашнее задание по курсу

Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и
деление). Применить при создании программы архитектурные паттерны, добавить
логирование калькулятора. Соблюдать принципы SOLID, паттерны проектирования. Можно
выбрать другой язык программирования, например C# или Python, если выбран язык,
отличный от JAVA, то необходимо написать документ, каким образом можно запустить
приложение (что необходимо установить, каким образом запускать и т.п.)
 */


import java.util.logging.*;
// Использования калькулятора комплексных чисел
public class Main {
    public static void main(String[] args) {
        // Создание комплексных чисел
        ComplexNumber number1 = new ComplexNumber(2, 3);
        ComplexNumber numer2 = new ComplexNumber(1, 2);

        // Создание логирования и калькулятора с выбранной операцией
        Logger logger = new ConsoleLogger(Calculator.class);
        Calculator calculator = new Calculator(new Addition(), logger);

        // Выполнение операции сложения
        ComplexNumber sum = calculator.calculate(number1, numer2);
        System.out.println("Сложение: " + sum);

        // Выполнение операции умножения
        Calculator calculator2 = new Calculator(new Multiplication(), logger);
        ComplexNumber product = calculator2.calculate(number1, numer2);
        System.out.println("Умножение: " + product);

        // Выполнение операции деления
        Calculator calculator3 = new Calculator(new Division(), logger);
        ComplexNumber quotient = calculator3.calculate(number1, numer2);
        System.out.println("Деление: " + quotient);
    }
}


// Интерфейс для операций над комплексными числами
interface ComplexOperation {
    ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2);
}

// Конкретная реализация операции сложения
class Addition implements ComplexOperation {
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getReal() + num2.getReal();
        double imaginary = num1.getImaginary() + num2.getImaginary();
        return new ComplexNumber(real, imaginary);
    }
}

// Конкретная реализация операции умножения
class Multiplication implements ComplexOperation {
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double imaginary = num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal();
        return new ComplexNumber(real, imaginary);
    }
}

// Конкретная реализация операции деления
class Division implements ComplexOperation {
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double denominator = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        double real = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / denominator;
        double imaginary = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / denominator;
        return new ComplexNumber(real, imaginary);
    }
}

// Класс комплексного числа
class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

// Интерфейс для логирования
interface Logger {
    void log(String message);
}

// Логирование с помощью java.util.logging.Logger
class ConsoleLogger implements Logger {
    private java.util.logging.Logger logger;

    public ConsoleLogger(Class<?> clazz) {
        logger = java.util.logging.Logger.getLogger(clazz.getName());
    }

    public void log(String message) {
        logger.info(message);
    }
}

// Класс калькулятора
class Calculator {
    private ComplexOperation operation;
    private Logger logger;

    public Calculator(ComplexOperation operation, Logger logger) {
        this.operation = operation;
        this.logger = logger;
    }

    // Метод для выполнения операции над комплексными числами
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        // Выполняем операцию над комплексными числами
        ComplexNumber result = operation.calculate(num1, num2);
        
        // Логг результата операции
        logger.log("Calculation result: " + result);
        
        return result;
    }
}
