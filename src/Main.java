import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        var scannerValor = new Scanner(System.in);
        var scannerTexto = new Scanner(System.in);
        var scannerCpf = new Scanner(System.in);
        int jumper = 0;
        
        var penf = new Enfermeira();
        
        System.out.print("CPF da Enfermeira que está aplicando Vacina: ");
        penf.setCpf(scannerCpf.next());
        
        System.out.print("Nome da Enfermeira que está aplicando Vacina: ");
        penf.setNome(scannerTexto.next());
        
        System.out.printf("%s, Seja Bem vindo(a) ao sistema de Vacinação\n", penf.getNome().toUpperCase());
        
        
        ArrayList<Cidadao> arquivarCidadao = new ArrayList();
        
        do{
           tabela();
            jumper = scannerValor.nextInt();
           
           switch(jumper){
               case 1:
                   var cidadao = new Cidadao();
                   var sdf1= new SimpleDateFormat("dd/MM/yyyy");
                   
                   System.out.print("Digite o CPF do cidadão: ");
                   cidadao.setCpf(scannerCpf.next());
                   System.out.print("Digite o Nome do cidadão: ");
                   cidadao.setNome(scannerTexto.next().toUpperCase());
                   
                   System.out.print("Digite a data da 1ª dose(dia/Mês/ano): ");
                   cidadao.setDtPrimeiraDose(scannerTexto.next());
                   Date dataDose1 = sdf1.parse(cidadao.getDtPrimeiraDose());
                   
                   System.out.print("Digite a data da 2ª dose(dia/Mês/ano): ");
                   cidadao.setDtSegundaDose(scannerTexto.next());
                   Date dataDose2 = sdf1.parse(cidadao.getDtSegundaDose());
                   
                   long data = Math.abs(dataDose1.getTime() - dataDose2.getTime()) ; 
                   long dias = TimeUnit.DAYS.convert(data, TimeUnit.MILLISECONDS);
                   if(dias < 120){
                       System.out.println("Segunda Dose deve ser Aplicada 4 meses após a primeira");
                   }else{
                       System.out.print("Digite a data da 3ª dose(dia/Mês/ano): ");
                       cidadao.setDtTerceiraDose(scannerTexto.next());
                       Date dataDose3 = sdf1.parse(cidadao.getDtTerceiraDose());
                       
                       data = Math.abs(dataDose2.getTime() - dataDose3.getTime()) ; 
                       dias = TimeUnit.DAYS.convert(data, TimeUnit.MILLISECONDS);
                       
                       if(dias < 120){
                           System.out.println("Terceira Dose deve ser Aplicada 4 meses após a primeira");                           
                       }else{
                           System.out.print("Digite a data da 4ª dose(dia/Mês/ano): ");
                           cidadao.setDtQuartaDose(scannerTexto.next());
                           Date dataDose4 = sdf1.parse(cidadao.getDtQuartaDose());
                           data = Math.abs(dataDose2.getTime() - dataDose3.getTime()) ; 
                           dias = TimeUnit.DAYS.convert(data, TimeUnit.MILLISECONDS);
                           
                           if(dias < 120){
                              System.out.print("Terceira Dose deve ser Aplicada 4 meses após a primeira");
                           }else{
                               arquivarCidadao.add(cidadao);
                           }
                       }
                   }                   
               break;
               case 2:
                   if(arquivarCidadao.size() > 0){
                       for (int i = 0; i < arquivarCidadao.size(); i++) {
                           arquivarCidadao.get(i).imprimirDados();
                       }
                   }else{
                       System.out.println("Não existe dados Cadastrados");
                   }
               
               break;
               case 0:
               
               break;
               default:
                   System.out.println("Sair");
               break;
           }
            
        }while(jumper != 0);
        
    }
    public static void tabela(){

        System.out.println
                ("""
                -=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=
                1 - Cadastrar/vacinar cidadão;
                2 - Listar cidadãos vacinados
                3 - Sair
                -=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=
                """);

    }
    
}
