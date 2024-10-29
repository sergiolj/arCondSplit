package arCondicionadoSplit;

public class TesteSemMenu {

	public static void main(String[] args) {

		ControleRemoto controle = new ControleRemoto();
		controle.getEvaporadora();
		
		System.out.println("Status inicial");
		controle.displayInfo();
		
		controle.setOnOff();
		
		System.out.println("Status após ligar");
		controle.displayInfo();
		

		controle.setTemperature();
		
		System.out.println("Status após definir temperatura para 25°C");
		controle.displayInfo();
		
		controle.decreaseTemperature();
		controle.decreaseTemperature();
		controle.decreaseTemperature();
		controle.decreaseTemperature();
		controle.decreaseTemperature();
		
		System.out.println("Status após dimunuir temperatura 5x");
		controle.displayInfo();
		
		controle.increaseTemperurature();
		controle.increaseTemperurature();
		
		System.out.println("Status após aumentar temperatura 2x");
		controle.displayInfo();

		controle.changeFanVelocity();

		System.out.println("Status após comutar velocidade do ventilador 1x");
		controle.displayInfo();
		
		controle.changeFanVelocity();
		
		System.out.println("Status após comutar velocidade do ventilador 1x");
		controle.displayInfo();

		controle.setSwingOnOFF();
		controle.changeFanVelocity();
		System.out.println("Status após comutar função swing e função ventilador");
		controle.displayInfo();
	}

}
