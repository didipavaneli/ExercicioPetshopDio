public class Principal {
    public static void main(String[] args) {
        MaquinaDeBanho m = new MaquinaDeBanho();

        //Abastecer Recursos
        m.abastecerAgua(30); //enche ate a capacidade maxima
        m.abastecerShampoo(10); //enche ate a capacidade maxima


        //Primeiro pet
        m.colocarPet("Bud");
        m.darBanho(); // consome 10 L água + 2 L shampoo
        m.retirarPet(); // pet está limpo → pode entrar outro diretamente


        // Segundo pet (não vai conseguir banho porque falta recurso)
        m.colocarPet("Mia");
        // Simulamos consumo anterior: água = 20 L, shampoo = 8 L
        // Vamos tentar banho sem recurso suficiente:
        try{
            m.darBanho();
        }catch (Exception e){
            System.out.println("Erro ao dar banho: " + e.getMessage());
        }
        // Limpar a máquina (consome 3 L água + 1 L shampoo) e abastecer novamente
        m.limparMaquina();
        m.abastecerAgua(5);
        m.abastecerShampoo(2);

        //Agora o banho funciona
        m.darBanho();
        m.retirarPet();

        //Estado final
        System.out.println(m);
    }



}