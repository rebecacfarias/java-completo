package funcionalLambda.application;

/**
  EXERCICIO ENVOLVENDO PROGRAMAÇÃO FUNCIONAL E EXPRESSÕES LAMBDA
    Fazer um programa para ler os dados (nome, email e salário)
    de funcionários a partir de um arquivo em formato .csv.
    Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo salário seja superior a um dado 
    valor fornecido pelo usuário.
    Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'.

  AUTHOR: Rebeca Cunha de Farias
 */


import funcionalLambda.entities.Employee;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");   
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Employee> employeeList = new ArrayList<>();

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                employeeList.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Minimal salary to get list: ");
            Double minimal = sc.nextDouble();
            sc.nextLine();

            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emailsList = employeeList.stream().filter(e -> e.getSalary() >= minimal).map(e -> e.getEmail()).sorted(comp)
            .collect(Collectors.toList());

            System.out.printf("\nEmails of employees with salary above %.2f: \n",minimal);
            emailsList.forEach(System.out::println);
            
            Double sum = employeeList.stream().filter(e -> e.getName().toUpperCase().charAt(0) == 'M').map(e -> e.getSalary()).reduce(0.0, (x,y) -> x+y);
            System.out.printf("\nSum of salaries from people whose names start with 'M': %.2f", sum);

        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        sc.close();


}
}
