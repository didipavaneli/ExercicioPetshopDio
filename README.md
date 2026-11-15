# Controle de Banho de PetShop em Java

## Descrição
Este projeto implementa o controle da máquina de banho de um pet shop, conforme o exercício proposto.  A máquina permite que **apenas um pet** esteja em banho por vez e gerencia recursos de **água** e **shampoo**.

## Regras de Negócio
- Cada banho consome **10 L de água** e **2 L de shampoo**.
- Capacidade máxima da máquina: **30 L de água** e **10 L de shampoo**.
- O abastecimento de água ou shampoo adiciona **2 L** por acionamento.
- A limpeza da máquina consome **3 L de água** e **1 L de shampoo**; a limpeza é obrigatória se o pet for retirado antes de estar limpo.
- Só é permitido **um pet por vez** na máquina.

## Estrutura do Código
```
src/
 └─ main/
     └─ java/
         └─ com.example.petshop/
             ├─ Pet.java          // representa o pet (nome, espécie, …)
             ├─ BathMachine.java  // lógica da máquina de banho
             └─ Main.java         // exemplo de uso / interface de linha de comando
```

### `Pet`
- Atributos básicos (nome, espécie).
- Pode ser estendido para incluir tamanho, etc.

### `BathMachine`
- **Campos internos:**
  - `int waterLevel` (litros)
  - `int shampooLevel` (litros)
  - `Pet currentPet`
  - `boolean needsCleaning`
- **Operações públicas:**
  - `void addWater()` – acrescenta 2 L, respeitando a capacidade.
  - `void addShampoo()` – acrescenta 2 L, respeitando a capacidade.
  - `void startBath(Pet pet)` – coloca o pet na máquina (verifica disponibilidade).
  - `void finishBath()` – consome 10 L de água e 2 L de shampoo; marca o pet como limpo.
  - `void removePet()` – retira o pet; se não estiver limpo, seta `needsCleaning = true`.
  - `void cleanMachine()` – consome 3 L de água e 1 L de shampoo; limpa a máquina.
  - `int getWaterLevel()`, `int getShampooLevel()`, `boolean isPetInside()`, `boolean isCleaningNeeded()` – consultas.

### `Main`
- Demonstração interativa via console (menu com as operações acima).
- Exemplo de fluxo:
  1. Abastecer água e shampoo até capacidade.
  2. Colocar um pet.
  3. Iniciar banho.
  4. Finalizar banho.
  5. Retirar pet.
  6. Limpar máquina (se necessário).

## Como Compilar e Executar
```bash
# No diretório do projeto
javac -d out src/main/java/com/example/petshop/*.java
java -cp out com.example.petshop.Main
```

## Contribuição
Sinta‑se à vontade para melhorar o código, adicionar testes unitários (JUnit) ou estender a lógica para múltiplas máquinas.

