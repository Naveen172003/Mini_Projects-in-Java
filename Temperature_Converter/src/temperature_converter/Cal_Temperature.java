/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temperature_converter;

/**
 *
 * @author Naveen Raj. K
 */
public class Cal_Temperature {
    public double[] celsiusToFahrenheit(double[] temperatures){
        double[] Fahrenheit=new double[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            Fahrenheit[i]=temperatures[i]*9/5+32;
        }
        return Fahrenheit;
        
    }
    public double[] celsiusToKelvin(double[] temperatures){
        double[] Kelvin=new double[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            Kelvin[i]=temperatures[i]+273.15;
        }
        return Kelvin;
    }
    public double Calculate_avg(double[] temperatures)
    {
        double sum=0;
        for(double temp:temperatures){
            sum+=temp;
        }
        return sum/temperatures.length;
    }
    
}
