package arCondicionadoSplit;

import java.util.Scanner;

public class ControleRemoto {
	
	// O modificador protected foi adicionado para possibilitar a vinculação no TesteMain entre o ControleRemoto e a Evaporadora
	private Evaporadora evaporadora = new Evaporadora();
	private Scanner sc = new Scanner(System.in);
	
	
	public Evaporadora getEvaporadora() {
		return this.evaporadora;
		
	}
	// Acionamento do botão comutador de ligar e desligar do ar condicionado
	public void setOnOff() {
		evaporadora.setSwitched();
	}
	
	// Define um valor de temperatura específico
	public void setTemperature() {
		int temperature;
		System.out.println("Informe a temperatura desejada");
		temperature = sc.nextInt();
		evaporadora.setTemperature(temperature);
	}
	
	// Acionamento do botão comutador de ligar e desligar da função swing da evaporadora
	public void setSwingOnOFF() {
		evaporadora.setSwingOnOff();
	}	
	
	// Acionamento do botão para diminuir a temperatura (Botão -C)
	public void decreaseTemperature() {
		evaporadora.decreaseTemperature();
	}
	
	//Acionamento do botão para aumenta a temperatura (Botão +C)
	public void increaseTemperurature() {
		evaporadora.increaseTemperature();
	}
	
	//Acionamento do botão comutador para alternar a velocidade do ventilador
	public void changeFanVelocity() {
		evaporadora.setFanFlowVelocity();
		
	}
	
	public void menuOpcoes() {
		boolean continuar=true;
		int escolha=0;
		while(continuar) {
			System.out.println("Escolha a opção desejada (1-6) (0-Sair): ");
			funcoes();
			escolha=sc.nextInt();
			if((escolha >= 0) && (escolha <=6)) {
				switch(escolha) {
				case 0:
					continuar=false;
					break;
				
				case 1:
					setOnOff();
					displayInfo();
					break;
				
				case 2:
					setTemperature();
					displayInfo();
					break;
				
				case 3:
					increaseTemperurature();
					displayInfo();
					break;
				
				case 4:
					decreaseTemperature();
					displayInfo();
					break;
				
				case 5:
					setSwingOnOFF();
					displayInfo();
					break;
				
				case 6:
					changeFanVelocity();
					displayInfo();
					break;
				}
			}else {
				System.out.println("Opção inválida");
			}
		}
	}
	
	private void funcoes() {
		System.out.println("0 - Sair");
		System.out.println("1 - Ligar / Desligar");
		System.out.println("2 - Temperatura - Definir");
		System.out.println("3 - Temperatura - Aumentar");
		System.out.println("4 - Temperatura - Diminuir");
		System.out.println("5 - Swing - Ligar / Desligar");
		System.out.println("6 - Ventilador - Mudar Velocidade");
	}

	//Método criado para simular o Display do Controle Remoto
	public void displayInfo() {
		    System.out.printf("%-25s: %s%n", "Status", switchStatus());
		    System.out.printf("%-25s: %s°C%n", "Temperatura ambiente", evaporadora.getTemperatureSensor());
		    System.out.printf("%-25s: %s %% %n", "Umidade", evaporadora.getHumiditySensor());
		    System.out.printf("%-25s: %s°C%n", "Temperatura desejada", evaporadora.getTemperature());
		    System.out.printf("%-25s: %s%n", "Ventilador", fanIcon());
		    System.out.printf("%-25s: %s%n", "Swing vertical", swingIcon()+"\n");
	}
	
	// Informação iconográfica para o status da velocidade do ventilador da evaporadora
	public String fanIcon() {
		switch(evaporadora.getFanVelocitySet()) {
		case LOW:
			return "LOW *";
			
		case MEDIUM:
			return "MID ***";
			
		case HIGH:
			return "HIGH *****";
			
		default:
			return "error";
		}
	}
	
	// Informação iconográfica para o status de ligado ou desligado do sistema
	public String switchStatus() {
		switch(evaporadora.getSwitched()) {
		
		case ON:
			return "< LIGADO >";
		
		case OFF:
			return "< DESLIGADO >";
			
		default: 
			return " error ";
		}
	}
	
	// Informação iconográfica para o status da função swing para ligado ou desligado
	public String swingIcon() {
		switch(evaporadora.getDirectioMovement()) {
		
		case ON:
			return " ON [ ⇈ ⇊ ] ";
	
		case OFF:
			return " OFF [ --- ]";
			
		default:
			return "error";
		}
	}
}
