import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        Scanner scannerValor = new Scanner(System.in);
        Scanner scannerTexto = new Scanner(System.in);
        Scanner scannerCpf = new Scanner(System.in);
        int op = 0;
        
        enfermeira enf = new enfermeira();
        
        System.out.println("CPF da Enfermeira que está aplicando Vacina: ");
        enf.setCpf(scannerCpf.next());
        
        System.out.println("Nome da Enfermeira que está aplicando Vacina: ");
        enf.setNome(scannerTexto.next());
        
        System.out.println(enf.getNome()+ " Seja Bem vindo(a) ao sistema de Vacinação\n");
        
        
        ArrayList<Cidadao> listaCidadao = new ArrayList();
        
        do{
           menu();
           op = scannerValor.nextInt();
           
           switch(op){
               case 1:
                   Cidadao cidadao = new Cidadao();
                   SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); 
                   
                   System.out.println("Informe o CPF do cidadão: ");
                   cidadao.setCpf(scannerCpf.next());
                   System.out.println("Informe o Nome do cidadão: ");
                   cidadao.setNome(scannerTexto.next());
                   
                   System.out.println("Informe a data da 1ª dose(dia/Mês/ano): ");
                   cidadao.setDtPrimeiraDose(scannerTexto.next());
                   Date dataDose1 = sdf1.parse(cidadao.getDtPrimeiraDose());
                   
                   System.out.println("Informe a data da 2ª dose(dia/Mês/ano): ");
                   cidadao.setDtSegundaDose(scannerTexto.next());
                   Date dataDose2 = sdf1.parse(cidadao.getDtSegundaDose());
                   
                   long data = Math.abs(dataDose1.getTime() - dataDose2.getTime()) ; 
                   long dias = TimeUnit.DAYS.convert(data, TimeUnit.MILLISECONDS);
                   if(dias < 120){
                       System.out.println("Segunda Dose deve ser Aplicada 4 meses após a primeira");
                   }else{
                       System.out.println("Informe a data da 3ª dose(dia/Mês/ano): ");
                       cidadao.setDtTerceiraDose(scannerTexto.next());
                       Date dataDose3 = sdf1.parse(cidadao.getDtTerceiraDose());
                       
                       data = Math.abs(dataDose2.getTime() - dataDose3.getTime()) ; 
                       dias = TimeUnit.DAYS.convert(data, TimeUnit.MILLISECONDS);
                       
                       if(dias < 120){
                           System.out.println("Terceira Dose deve ser Aplicada 4 meses após a primeira");                           
                       }else{
                           System.out.println("Informe a data da 4ª dose(dia/Mês/ano): ");
                           cidadao.setDtQuartaDose(scannerTexto.next());
                           Date dataDose4 = sdf1.parse(cidadao.getDtQuartaDose());
                           data = Math.abs(dataDose2.getTime() - dataDose3.getTime()) ; 
                           dias = TimeUnit.DAYS.convert(data, TimeUnit.MILLISECONDS);
                           
                           if(dias < 120){
                              System.out.println("Terceira Dose deve ser Aplicada 4 meses após a primeira");                           
                           }else{
                               listaCidadao.add(cidadao);
                           }
                       }
                   }                   
               break;
               case 2:
                   if(listaCidadao.size() > 0){
                       for (int i = 0; i < listaCidadao.size(); i++) {
                           listaCidadao.get(i).imprimirDados();
                       }
                   }else{
                       System.out.println("Não existe dados Cadastrados");
                   }
               
               break;
               case 0:
               
               break;
               default:
                   System.out.println("Opção Inválida");
               break;
           }
            
        }while(op != 0);
        
    }
    public static void menu(){
        System.out.println("------------------------------");
        System.out.println("1- vacinar cidadão\n2-listar cidadãos vacinados\n0-sair");
        System.out.println("------------------------------");
    }
    
}
