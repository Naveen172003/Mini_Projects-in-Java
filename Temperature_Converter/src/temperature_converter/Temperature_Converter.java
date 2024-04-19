/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temperature_converter;

import java.util.Scanner;

/**
 *
 * @author Naveen Raj. K
 */
public class Temperature_Converter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter No. Of day's : ");
        int days=sc.nextInt();
        double arr[]=new double[days];
      
        for(int i=0;i<days;i++)
        {
            System.out.println("Enter Temperature for Days "+(i+1)+"'s in celsius:");
            arr[i]=sc.nextDouble();
        }
        
        Cal_Temperature converter=new Cal_Temperature();
        double avg_celsius=converter.Calculate_avg(arr);
        System.out.println("Average Temperature for "+days+" day's in celsius: "+avg_celsius);
        
        double[] TemperatureFahrenheit=converter.celsiusToFahrenheit(arr);
        double[] TemperatureKelvin=converter.celsiusToKelvin(arr);
        
        double avg_Fahrenheit=converter.Calculate_avg(TemperatureFahrenheit);
        System.out.println("Average Temperature for Fahrenheit : "+avg_Fahrenheit);
        
        double avg_Kelvin=converter.Calculate_avg(TemperatureKelvin);
        System.out.println("Average Temperature for Kelvin is : "+ avg_Kelvin);
        
        System.out.println();
        
    }
}

    

