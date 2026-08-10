package org.example;


public class TemperatureConverter {

        // convert celsius to fahrenheit
        public static double celsiusToFahrenheit (double celsius){
            return (celsius * 9/5) +32;
        }
        // convert Fahrenheit to celsius
        public static double fahrenheitToCelsius(double fahrenheit){
            return (fahrenheit -32) *5/9 ;
        }
        // Convert Celsius to Kelvin
        public static double celsiusToKelvin(double celsius) {
            return celsius + 273.15;
        }
    public static void printFormatted(String format, double value1, double value2) {
        String result = String.format(format, value1, value2);
        System.out.println(result);
    }

        public static void main(String[] args) {
            double celsius1 = 0;
            double celsius2 = 100;
            double fahrenheit = 32;
            double fahrenheit1 = celsiusToFahrenheit(celsius1);
            double fahrenheit2 = celsiusToFahrenheit(celsius2);
            double celsius = fahrenheitToCelsius(fahrenheit);
            double kelvin = celsiusToKelvin(celsius1);

            // Reusing formatting logic (no repetition)
            printFormatted("%.2f °C = %.2f °F", celsius1, fahrenheit1);
            printFormatted("%.2f °C = %.2f °F", celsius2, fahrenheit2);
            printFormatted("%.2f °F = %.2f °C", fahrenheit, celsius);
            printFormatted("%.2f °C = %.2f K", celsius1, kelvin);


        }
    }

