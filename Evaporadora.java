package arCondicionadoSplit;

import arCondicionadoSplit.util.FanVelocitySet;
import arCondicionadoSplit.util.SwitchStatus;

/**
 * Classes e métodos criados para explorar os conceitos de orientação a objetos e a
 * abstração e encapsulamento de atributos e métodos.
 * Classe Evaporadora controla seus atributos e sensores e recebe comandos da Classe 
 * ControleRemoto
 */

public class Evaporadora {
	
	private Condensadora condensadora = new Condensadora();
	/**
	 * 	Utiliza um ENUM como um objeto da Classe Evaporadora e Condensadora com os estados possíveis ON, OFF para controlar
	 * o acionamento das unidades e também do swing
	 */
	private SwitchStatus switched;
	private int temperature;
	
	/**
	 * Utiliza o ENUM FanVelocitySet com as opções LOW, MEDIUM e HIGH para controle do ventilador
	 * da Evaporadora
	 */
	private FanVelocitySet fanFlowVelocity;
	private SwitchStatus swingOnOff;
	
	// Atributos definidos pelo funcionamento do sensor da Evaporadora
	private int temperatureSensor;
	private int humiditySensor;
	
	// Construtor da classe com os padrões de inicialização
	public Evaporadora(){
		this.switched = SwitchStatus.OFF;
		this.temperature = 20;
		this.fanFlowVelocity = FanVelocitySet.LOW;
		this.swingOnOff = SwitchStatus.ON;
		this.humiditySensor = getHumiditySensor();
		this.temperatureSensor = getTemperatureSensor();
	}
	
	// Instrução para ligar e desligar a evaporadora e a condensadora
	public void setSwitched() {
		condensadora.setSwitched();
		if(this.switched == SwitchStatus.ON) {
			this.switched = SwitchStatus.OFF;
		}else {
			this.switched = SwitchStatus.ON;
		}
		
	}
	
	// Método get necessário para verificar o status do atributo pelo ControlRemoto
	public SwitchStatus getSwitched() {
		return this.switched;
	}
	
	// Método para definir uma temperatura específica sem necessidade de diminuir ou aumentar em 1 grau por vez
	public void setTemperature(int temperature) {
		this.temperature = temperature;	
	}
	
	// Método get necessário para verificar o status do atributo pelo ControlRemoto
	public int getTemperature() {
		return this.temperature;
	}
	
	// Método get necessário para verificar o status do atributo pelo ControlRemoto
	public int getTemperatureSensor() {
		// envia instruções ao sensor de temperatura para fazer a leitura e retornar o resultado
		temperatureSensor = 32;
		return temperatureSensor;
	}
	
	// Método get necessário para verificar o status do atributo pelo ControlRemoto
	public int getHumiditySensor() {
		// envia instruções ao sensor de humidade para fazer a leitura e retornar o resulado
		humiditySensor = 90;
		return humiditySensor;
	}
	
	// Método get necessário para verificar o status do atributo pelo ControlRemoto
	public SwitchStatus getDirectioMovement() {
		return this.swingOnOff;
	}
	
	// Método get necessário para verificar o status do atributo pelo ControlRemoto
	public FanVelocitySet getFanVelocitySet() {
		return fanFlowVelocity;
	}
	
	//Método para alternar a velocidade das aletas de direcionamento do fluxo de ar 
	public void setFanFlowVelocity() {
		
		switch (this.fanFlowVelocity){
		
		case LOW:
			this.fanFlowVelocity = FanVelocitySet.MEDIUM;
			break;
			
		case MEDIUM:
			this.fanFlowVelocity = FanVelocitySet.HIGH;
			break;
			
		case HIGH:
			this.fanFlowVelocity = FanVelocitySet.LOW;
			break;
		}
	}
	
	// Método para comutar o movimento vertical das aletas de ventilação para as posições ligado ou desligado
	public void setSwingOnOff() {
		if(swingOnOff == SwitchStatus.ON) {
			this.swingOnOff=SwitchStatus.OFF;
		}else {
			this.swingOnOff = SwitchStatus.ON;
		}
	}

	// Método usado para diminuir em um grau a temperatura
	public int decreaseTemperature() {
		this.temperature -= 1;
		return temperature;
	}

	// Método usado para aumentar em um grau a temperatura
	public int increaseTemperature() {
		this.temperature += 1;
		return temperature;
		
	}
}
